package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Perfil_Usuario extends AppCompatActivity {

    SQLiteConexion db = new SQLiteConexion(this);
    TextView titulo;
    EditText nombre, apellidos, email, telefono, colegio;
    Button editar, cambiarpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        titulo = (TextView) findViewById(R.id.perfilTitulo);
        nombre = (EditText) findViewById(R.id.perfilNombre);
        apellidos = (EditText) findViewById(R.id.perfilApellidos);
        email = (EditText) findViewById(R.id.perfilEmail);
        telefono = (EditText) findViewById(R.id.perfilTelefono);
        colegio = (EditText) findViewById(R.id.perfilColegio);
        editar = (Button) findViewById(R.id.btnEditar);
        cambiarpass = (Button) findViewById(R.id.btnCambiarpass);


        Usuarios usuario = db.getUser(idUsuario);
        titulo.setText(usuario.getNombre() + " " + usuario.getApellidos());
        nombre.setText(usuario.getNombre());
        apellidos.setText(usuario.getApellidos());
        //telefono.setText(usuario.getTelefono());
        email.setText(usuario.getEmail());
        //colegio.setText(usuario.getColegio());

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long codigoinsert = db.editarUsuario(idUsuario, nombre.getText().toString(),apellidos.getText().toString(),email.getText().toString());


            }
        });
    }
}