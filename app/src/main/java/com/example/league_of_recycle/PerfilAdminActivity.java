package com.example.league_of_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilAdminActivity extends AppCompatActivity {

    SQLiteConexion db;
    TextView responsable;
    EditText centro, direccion, email, telefono, id_centro;
    Button editar, ubicaCentro, ubicaConte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfiladmin);

        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        centro = (EditText) findViewById(R.id.admNombCentro);
        responsable = (TextView) findViewById(R.id.admResponsable);
        direccion = (EditText) findViewById(R.id.admDireccion);
        email = (EditText) findViewById(R.id.admEmail);
        telefono = (EditText) findViewById(R.id.admTelefono);
        editar = (Button) findViewById(R.id.btnEditar);
        //cambiarpass = (Button) findViewById(R.id.btnCambiarpass);
        ubicaCentro = (Button) findViewById(R.id.admButonAnadirCentro);
        ubicaConte = (Button) findViewById(R.id.admButonAnadirCont);

        db = new SQLiteConexion(this);
        Usuarios usuario = db.getUser(idUsuario);
        responsable.setText(usuario.getNombre() + " " + usuario.getApellidos());
        direccion.setText(usuario.getApellidos());
        //telefono.setText(usuario.getTelefono());
        email.setText(usuario.getEmail());
        //colegio.setText(usuario.getColegio());

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long codigoinsert = db.editarUsuario(idUsuario, centro.getText().toString(),responsable.getText().toString(),email.getText().toString(),telefono.getText().toString(),Integer.valueOf(id_centro.getText().toString()));
                Toast.makeText(PerfilAdminActivity.this, "Datos actualizados", Toast.LENGTH_LONG).show();

                finish();
                startActivity(getIntent());
            }
        });

        ubicaCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapa = new Intent(PerfilAdminActivity.this, MapsSelectActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                startActivity(mapa);
            }
        });

        ubicaConte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapa = new Intent(PerfilAdminActivity.this, MapsSelectActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                startActivity(mapa);
            }
        });
    }
}