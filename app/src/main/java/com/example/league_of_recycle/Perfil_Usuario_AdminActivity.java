package com.example.league_of_recycle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil_Usuario_AdminActivity extends AppCompatActivity {

    SQLiteConexion db = new SQLiteConexion(this);
    TextView centro;
    EditText nombre, responsable, email, telefono, id_centro;
    Button editar, cambiarpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_admin);

        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        centro = (TextView) findViewById(R.id.perfilCentro);
        nombre = (EditText) findViewById(R.id.perfilNombre);
        responsable = (EditText) findViewById(R.id.perfilRes);
        email = (EditText) findViewById(R.id.perfilEmail);
        telefono = (EditText) findViewById(R.id.perfilTelefono);
        id_centro = (EditText) findViewById(R.id.perfilIdcentro);
        editar = (Button) findViewById(R.id.btnEditar);
        cambiarpass = (Button) findViewById(R.id.btnCambiarpass);


        Usuarios usuario = db.getUser(idUsuario);
        centro.setText(usuario.getNombre() + " " + usuario.getApellidos());
        nombre.setText(usuario.getNombre());
        responsable.setText(usuario.getApellidos());
        //telefono.setText(usuario.getTelefono());
        email.setText(usuario.getEmail());
        //colegio.setText(usuario.getColegio());

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long codigoinsert = db.editarUsuario(idUsuario, centro.getText().toString(),responsable.getText().toString(),email.getText().toString(),telefono.getText().toString(),Integer.valueOf(id_centro.getText().toString()));

            }
        });
    }
}