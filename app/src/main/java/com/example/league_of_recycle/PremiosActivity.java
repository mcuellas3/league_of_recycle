package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.league_of_recycle.databinding.ActivityPremiosBinding;

public class PremiosActivity extends AppCompatActivity {


    Button ranking;
    int idUsuario;
    ImageButton casa, mapa, escaner, informacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premios);

        Bundle b = this.getIntent().getExtras();
        int idUsuario = b.getInt("idUsuario");
        ranking = (Button) findViewById(R.id.premTabRanking);

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tab = new Intent(PremiosActivity.this, RankingActivity.class);
                tab.putExtra("idUsuario", idUsuario);
                startActivity(tab);
            }
        });

        // Casa
        casa = findViewById(R.id.imageButton77);

        casa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent casa = new Intent(PremiosActivity.this, HomeActivity.class);
                casa.putExtra("idUsuario", idUsuario);
                startActivity(casa);
            }
        });

        // Mapa
        mapa = findViewById(R.id.imageButton122);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mapa = new Intent(PremiosActivity.this, MapsActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                startActivity(mapa);
            }
        });

        // Scaner
        escaner = findViewById(R.id.imageButton133);

        escaner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent escaner = new Intent(PremiosActivity.this, ScanerActivity.class);
                escaner.putExtra("idUsuario", idUsuario);
                startActivity(escaner);
            }
        });


        // Informacion
        informacion = findViewById(R.id.imageButton155);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent informacion = new Intent(PremiosActivity.this, InfoActivity.class);
                informacion.putExtra("idUsuario", idUsuario);
                startActivity(informacion);
            }
        });
    }
}