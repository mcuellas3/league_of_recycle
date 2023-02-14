package com.example.league_of_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class RecpassActivity extends AppCompatActivity {

    SQLiteConexion db = new SQLiteConexion(this);
    EditText usuario;
    MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recpass);
        //getActionBar().hide();

        usuario = (EditText) findViewById(R.id.usuarioRecpass);
        btnLogin = (MaterialButton) findViewById(R.id.btnSend);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Usuarios user = db.getUser(idUsuario);
                Intent i = new Intent(RecpassActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}