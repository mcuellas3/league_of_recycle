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



    }

    private void inicializar(){
        if(db.cantidadRegistros("productos")==0){
            String[] texto = leerArchivo(R.raw.productos);

            for (int i=0;i< texto.length;i++){
                String[] linea = texto[i].split(";");
                ContentValues cv = new ContentValues();
                cv.put("codigo",(linea[0]));
                cv.put("marca",(linea[1]));
                cv.put("nombre",(linea[2]));
                cv.put("categoria",(linea[3]));
                cv.put("cantidad",(linea[4]));
                cv.put("envase",(linea[5]));
                cv.put("greendot",(linea[6]));
                cv.put("puntos",(linea[7]));
                db.insertar("productos",cv);
            }
        }

        if(db.cantidadRegistros("centros")==0){
            String[] texto = leerArchivo(R.raw.centros);

            for (int i=0;i< texto.length;i++){
                String[] linea = texto[i].split(";");
                ContentValues cv = new ContentValues();
                cv.put("nombre",(linea[0]));
                cv.put("lat",(linea[1]));
                cv.put("lon",(linea[2]));
                cv.put("responsable",(linea[3]));
                cv.put("direccion",(linea[4]));
                cv.put("telefono",(linea[5]));
                db.insertar("centros",cv);
            }
        }
    }


    private String[] leerArchivo(int res ) {
        InputStream inputStream = getResources().openRawResource(res);
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