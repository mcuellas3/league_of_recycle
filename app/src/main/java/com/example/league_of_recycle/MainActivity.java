package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;


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

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }
}