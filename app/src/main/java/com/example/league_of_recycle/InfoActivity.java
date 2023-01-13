package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InfoActivity extends AppCompatActivity {

    ImageButton casa;
    ImageButton mapa;
    ImageButton escaner;
    ImageButton ranking;
    ImageButton informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Casa
        casa = findViewById(R.id.imageButton7);

        casa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent home = new Intent(InfoActivity.this, LoginActivity.class);
                startActivity(home);
            }
        });

        // Mapa
        mapa = findViewById(R.id.imageButton12);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent map = new Intent(InfoActivity.this, MapsActivity.class);
                startActivity(map);
            }
        });

        // Scaner
        escaner = findViewById(R.id.imageButton13);

        escaner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent scan = new Intent(InfoActivity.this, ScanerActivity.class);
                startActivity(scan);
            }
        });

        // Ranking
        ranking = findViewById(R.id.imageButton14);

        ranking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent rank = new Intent(InfoActivity.this, RankingActivity.class);
                startActivity(rank);
            }
        });

        // Informacion
        informacion = findViewById(R.id.imageButton15);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent info = new Intent(InfoActivity.this, InfoActivity.class);
                startActivity(info);
            }
        });
    }

}