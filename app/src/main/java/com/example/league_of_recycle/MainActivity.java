package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText email, nombre, apellidos, pass, repass;
    Button registerbtn;
    TextView yaEstoyRegistrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteConexion db = new SQLiteConexion(this);
        db.open();
        email = (EditText) findViewById(R.id.emailRegister);
        nombre = (EditText) findViewById(R.id.nombreRegister);
        apellidos = (EditText) findViewById(R.id.apellidosRegister);
        pass = (EditText) findViewById(R.id.passwordRegister);
        repass = (EditText) findViewById(R.id.repitePasswordRegister);
        registerbtn = (Button) findViewById(R.id.registerbtn);
        yaEstoyRegistrado = (TextView) findViewById(R.id.yaEstoyRegistrado);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuarios usuario = new Usuarios(nombre.getText().toString(), apellidos.getText().toString(), email.getText().toString(), pass.getText().toString());
                Long codigo = db.guardarUsuario(usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getPass());

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        yaEstoyRegistrado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void consultaUsuariosDB(){

    }
}