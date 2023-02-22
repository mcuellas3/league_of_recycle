package com.example.league_of_recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PerfilAdminActivity extends AppCompatActivity {

    SQLiteConexion db;
    TextView responsable;
    EditText centro, direccion, email, telefono, id_centro;
    Button editar, ubicaCentro, ubicaConte;
    ListView listacont;
    private ArrayList<String> lista;
    String tipo, ubicar;
    Spinner tipocont;
    ArrayList<contenedores> cont;


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
        ubicaCentro = (Button) findViewById(R.id.admButonAnadirCentro);
        ubicaConte = (Button) findViewById(R.id.admButonAnadirCont);
        listacont = (ListView) findViewById(R.id.listaCont);
        tipocont = (Spinner) findViewById(R.id.admTipoCont);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        db = new SQLiteConexion(this);
        Usuarios usuario = db.getUser(idUsuario);

        Centros ctr = db.getCentro(usuario.getCentro());

        centro.setText(ctr.getNombre());
        responsable.setText(usuario.getNombre() + " " + usuario.getApellidos());
        direccion.setText(ctr.getDireccion());
        telefono.setText(ctr.getTelefono());
        email.setText(usuario.getEmail());


        lista = new ArrayList<String>();
        cont = db.getContenedores(usuario.getCentro());

        for (contenedores c:cont) {

            lista.add(c.getTipo());

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listacont.setAdapter(adapter);


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
                ubicar="centro";
                Intent mapa = new Intent(PerfilAdminActivity.this, MapsSelectActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                mapa.putExtra("ubicar", ubicar);
                startActivity(mapa);
            }
        });

        ubicaConte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipo = String.valueOf(tipocont.getSelectedItem());

                if (tipo.equals("")){
                    Toast.makeText(PerfilAdminActivity.this, "Debes indicar un tipo de contenedor", Toast.LENGTH_LONG).show();

                }else {
                    Intent mapa = new Intent(PerfilAdminActivity.this, MapsSelectActivity.class);
                    ubicar = "contenedor";
                    mapa.putExtra("idUsuario", idUsuario);
                    mapa.putExtra("ubicar", ubicar);
                    mapa.putExtra("tipo", tipo);
                    startActivity(mapa);
                }
            }
        });
    }
}