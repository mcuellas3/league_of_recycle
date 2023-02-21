package com.example.league_of_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class RecpassActivity extends AppCompatActivity {

    SQLiteConexion db;
    EditText usuario;
    MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recpass);
        //getActionBar().hide();

        db = new SQLiteConexion(this);
        usuario = (EditText) findViewById(R.id.usuarioRepeatNewpass);
        btnLogin = (MaterialButton) findViewById(R.id.btnCambPass);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Usuarios user = db.getUser(idUsuario);
                Intent i = new Intent(RecpassActivity.this, MainActivity.class);
                Toast.makeText(RecpassActivity.this, "Recibiras en tu email instrucciones para el cambio de contraseña", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}