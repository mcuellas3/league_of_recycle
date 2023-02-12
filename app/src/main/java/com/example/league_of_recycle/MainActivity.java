package com.example.league_of_recycle;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    SQLiteConexion db = new SQLiteConexion(this);
    EditText usuario,pass;
    TextView registrateAqui;
    Button lectorQR;
    MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        usuario = (EditText) findViewById(R.id.usuarioLogin);
        pass = (EditText) findViewById(R.id.passwordLogin);
        btnLogin = (MaterialButton) findViewById(R.id.btnLogin);
        registrateAqui = (TextView) findViewById(R.id.others2);
        lectorQR = (Button) findViewById(R.id.lectorQR);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isEmailValid(usuario.getText().toString())) {
                    int idUsuario=db.login(usuario.getText().toString(), pass.getText().toString());
                    if (idUsuario!=0) {
                        //Usuarios user = db.getUser(idUsuario);
                        Intent i = new Intent(MainActivity.this, ScanerActivity.class);
                        i.putExtra("idUsuario", idUsuario);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "No existe el usuario", Toast.LENGTH_LONG).show();
                    }
                }
                else    {
                    Toast.makeText(MainActivity.this, "Debe Introducir un email", Toast.LENGTH_LONG).show();

                }
            }
        });

        registrateAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(i);
            }
        });

        lectorQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this, ScanerActivity.class);
                startActivity(j);
            }
        });

    }

    private void inicializar(){
        if(db.cantidadRegistros("productos")==0){
            String[] texto = leerArchivo();

            for (int i=0;i< texto.length;i++){
                String[] linea = texto[i].split(";");
                ContentValues cv = new ContentValues();
                cv.put("codigo",Codificador(linea[0]));
                cv.put("marca",Codificador(linea[1]));
                cv.put("nombre",Codificador(linea[2]));
                cv.put("categoria",Codificador(linea[3]));
                cv.put("cantidad",Codificador(linea[4]));
                cv.put("envase",Codificador(linea[5]));
                cv.put("greendot",Codificador(linea[6]));
                db.insertar("productos",cv);
            }
        }
    }

    public String Codificador(String cadena) {

        //byte[] ptext = cadena.getBytes(ANSI);
        //String resultado = new String(ptext,UTF_8);

        return cadena;
    }

    private String[] leerArchivo() {
        InputStream inputStream = getResources().openRawResource(R.raw.productos);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString().split("\n");
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }
}