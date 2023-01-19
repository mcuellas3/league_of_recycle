package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Perfil_Usuario extends AppCompatActivity {

    SQLiteConexion db = new SQLiteConexion(this);
    EditText nombre, apellidos, email, telefono, colegio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        nombre = (EditText) findViewById(R.id.perfilNombre);
        apellidos = (EditText) findViewById(R.id.perfilApellidos);
        email = (EditText) findViewById(R.id.perfilEmail);
        telefono = (EditText) findViewById(R.id.perfilTelefono);
        colegio = (EditText) findViewById(R.id.perfilColegio);

        db.getUsuarios();
    }
}