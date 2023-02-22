package com.example.league_of_recycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    ImageButton casa, mapa, escaner, ranking, informacion;
    SQLiteConexion db;
    ImageView desafio, noticias;
    TextView nombre, puntos, envases, huella, kilos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(this, Pop_Up.class);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.db = new SQLiteConexion(this);
        Bundle b = this.getIntent().getExtras();
        int idUsuario = b.getInt("idUsuario");


        nombre = (TextView) findViewById(R.id.nombreDelUsuario);
        puntos = (TextView) findViewById(R.id.tv_HomePuntos);
        envases = (TextView) findViewById(R.id.tv_HomeEnvases);
        huella = (TextView) findViewById(R.id.tv_HomeHuella);
        kilos = (TextView) findViewById(R.id.tv_HomeKilos);
        desafio = (ImageView)findViewById(R.id.desafio);
        noticias = (ImageView)findViewById(R.id.news);

        Usuarios usuario = db.getUser(idUsuario);



        nombre.setText(usuario.getNombre() + " " + usuario.getApellidos());
        puntos.setText(db.getPuntos(idUsuario));
        envases.setText(db.getEnvases(idUsuario));
        huella.setText(db.getHuella(idUsuario));
        kilos.setText(db.getPeso(idUsuario));


        desafio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(HomeActivity.this, DesafiosActivity.class);
                startActivity(pass);
            }
        });

        noticias.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(HomeActivity.this, NoticiasActivity.class);
                startActivity(pass);
            }
        });




        // Casa
        casa = findViewById(R.id.imageButton7);

        casa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent casa = new Intent(HomeActivity.this, HomeActivity.class);
                casa.putExtra("idUsuario", idUsuario);
                startActivity(casa);
            }
        });

        // Mapa
        mapa = findViewById(R.id.imageButton12);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mapa = new Intent(HomeActivity.this, MapsActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                startActivity(mapa);
            }
        });

        // Scaner
        escaner = findViewById(R.id.imageButton13);

        escaner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent escaner = new Intent(HomeActivity.this, ScanerActivity.class);
                escaner.putExtra("idUsuario", idUsuario);
                startActivity(escaner);
            }
        });

        // Ranking
        ranking = findViewById(R.id.imageButton14);

        ranking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ranking = new Intent(HomeActivity.this, RankingActivity.class);
                ranking.putExtra("idUsuario", idUsuario);
                startActivity(ranking);
            }
        });

        // Informacion
        informacion = findViewById(R.id.imageButton15);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent informacion = new Intent(HomeActivity.this, InfoActivity.class);
                informacion.putExtra("idUsuario", idUsuario);
                startActivity(informacion);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Bundle b = this.getIntent().getExtras();
        int idUsuario = b.getInt("idUsuario");

        switch ((item.getItemId())) {
            case R.id.item1:
                Usuarios usuario = db.getUser(idUsuario);

                if (!usuario.getIs_admin()) {
                    Intent perfil = new Intent(HomeActivity.this, Perfil_Usuario.class);
                    perfil.putExtra("idUsuario", idUsuario);
                    startActivity(perfil);
                } else {
                    Intent perfil = new Intent(HomeActivity.this, PerfilAdminActivity.class);
                    perfil.putExtra("idUsuario", idUsuario);
                    startActivity(perfil);
                }
                return true;

            case R.id.item2:
                Intent login = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(login);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
