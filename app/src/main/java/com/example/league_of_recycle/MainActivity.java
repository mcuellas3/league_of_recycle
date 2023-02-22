package com.example.league_of_recycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    SQLiteConexion db = new SQLiteConexion(this);
    EditText usuario,pass;
    TextView registrateAqui, forgotpass;
    MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().hide();

        inicializar();

        usuario = (EditText) findViewById(R.id.usuarioRepeatNewpass);
        pass = (EditText) findViewById(R.id.passwordLogin);
        btnLogin = (MaterialButton) findViewById(R.id.btnCambPass);
        forgotpass = (TextView) findViewById(R.id.forgotpass2);
        registrateAqui = (TextView) findViewById(R.id.txvRecpass);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isEmailValid(usuario.getText().toString())) {
                    int idUsuario=db.login(usuario.getText().toString(), pass.getText().toString());
                    if (idUsuario!=0) {
                        //Usuarios user = db.getUser(idUsuario);
                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        i.putExtra("idUsuario", idUsuario);
                        startActivity(i);

                    } else {
                        Toast.makeText(MainActivity.this, "No existe el usuario o la contraseña es incorrecta", Toast.LENGTH_LONG).show();
                    }
                }
                else    {
                    Toast.makeText(MainActivity.this, "Debe Introducir un email", Toast.LENGTH_LONG).show();

                }

            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(MainActivity.this, RecpassActivity.class);
                startActivity(pass);
            }
        });

        registrateAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(registro);
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
                cv.put("huella",(linea[7]));
                cv.put("peso",(linea[8]));
                cv.put("puntos",(linea[9]));
                cv.put("deg",(linea[10]));
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
        if(db.cantidadRegistros("usuarios")==0){
            String[] texto = leerArchivo(R.raw.usuarios);

            for (int i=0;i< texto.length;i++){
                String[] linea = texto[i].split(";");
                ContentValues cv = new ContentValues();
                cv.put("nombre",(linea[0]));
                cv.put("apellidos",(linea[1]));
                cv.put("email",(linea[2]));
                cv.put("pass",(linea[3]));
                cv.put("is_admin",(linea[4]));
                cv.put("telefono",(linea[5]));
                cv.put("id_centro",(linea[6]));
                db.insertar("usuarios",cv);
            }
        }
        if(db.cantidadRegistros("puntos")==0){
            String[] texto = leerArchivo(R.raw.puntos);

            for (int i=0;i< texto.length;i++){
                String[] linea = texto[i].split(";");
                ContentValues cv = new ContentValues();
                cv.put("id_usuario",(linea[0]));
                cv.put("id_producto",(linea[1]));
                db.insertar("puntos",cv);
            }
        }
        if(db.cantidadRegistros("contenedores")==0){
            String[] texto = leerArchivo(R.raw.contenedores);

            for (int i=0;i< texto.length;i++){
                String[] linea = texto[i].split(";");
                ContentValues cv = new ContentValues();
                cv.put("id_centro",(linea[0]));
                cv.put("tipo",(linea[1]));
                cv.put("lat",(linea[2]));
                cv.put("lon",(linea[3]));
                db.insertar("contenedores",cv);
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