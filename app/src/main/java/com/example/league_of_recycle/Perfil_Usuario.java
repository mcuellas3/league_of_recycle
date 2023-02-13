package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Perfil_Usuario extends AppCompatActivity {


    TextView titulo;
    EditText nombre, apellidos, email, telefono;
    Button editar, cambiarpass;
    Spinner centro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        titulo = (TextView) findViewById(R.id.perfilCentro);
        nombre = (EditText) findViewById(R.id.perfilNombre);
        apellidos = (EditText) findViewById(R.id.perfilRes);
        email = (EditText) findViewById(R.id.perfilEmail);
        telefono = (EditText) findViewById(R.id.perfilTelefono);
        centro = (Spinner) findViewById(R.id.perfilCentr);
        editar = (Button) findViewById(R.id.btnEditar);
        cambiarpass = (Button) findViewById(R.id.btnCambiarpass);


        SQLiteConexion db = new SQLiteConexion(this);
        Usuarios usuario = db.getUser(idUsuario);
        titulo.setText(usuario.getNombre() + " " + usuario.getApellidos());
        nombre.setText(usuario.getNombre());
        apellidos.setText(usuario.getApellidos());
        if (usuario.getTelefono() != null){
            telefono.setText(usuario.getTelefono());
        }
        email.setText(usuario.getEmail());
        if (usuario.getCentro() != 0){
            centro.setSelection(usuario.getCentro());
        }


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int codc=(int)centro.getSelectedItemId();
                //codc=codc+1;
                long codigoinsert = db.editarUsuario(idUsuario, nombre.getText().toString(),apellidos.getText().toString(),email.getText().toString(),telefono.getText().toString(),codc);

                Toast.makeText(Perfil_Usuario.this, "Datos actualizados", Toast.LENGTH_LONG).show();

                finish();
                startActivity(getIntent());

            }
        });
    }
}