package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText email, nombre, apellidos, pass, repass;
    Button registerbtn;
    TextView yaEstoyRegistrado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        SQLiteConexion db = new SQLiteConexion(this);
        email = (EditText) findViewById(R.id.emailRegister);
        nombre = (EditText) findViewById(R.id.nombreRegister);
        apellidos = (EditText) findViewById(R.id.apellidosRegister);
        pass = (EditText) findViewById(R.id.passwordRegister);
        repass = (EditText) findViewById(R.id.repitePasswordRegister);
        registerbtn = (Button) findViewById(R.id.registerbtn);
        yaEstoyRegistrado = (TextView) findViewById(R.id.iniciaSesion);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = pass.getText().toString();
                String repeatpassword = repass.getText().toString();

                if (password.equals(repeatpassword)){
                    Usuarios usuario = new Usuarios(nombre.getText().toString(), apellidos.getText().toString(), email.getText().toString(), pass.getText().toString());
                    Long codigoInsert = db.guardarUsuario(usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getPass(), false);

                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegistroActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }

            }
        });

        yaEstoyRegistrado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void consultaUsuariosDB(){

    }
}