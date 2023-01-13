package com.example.league_of_recycle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView detailsText;
    LinearLayout layout;

    ImageButton casa;
    ImageButton mapa;
    ImageButton escaner;
    ImageButton ranking;
    ImageButton informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        detailsText = findViewById(R.id.respuesta1);
        layout = findViewById(R.id.layout1);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void expand(View view){
        int v = (detailsText.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText.setVisibility(v);
    }

}