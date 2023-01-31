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

    TextView respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6;
    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6;

    ImageButton casa, mapa, escaner, ranking, informacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        respuesta1 = findViewById(R.id.respuesta1);
        layout1 = findViewById(R.id.layout1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        respuesta2 = findViewById(R.id.respuesta2);
        layout2 = findViewById(R.id.layout2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        respuesta3 = findViewById(R.id.respuesta3);
        layout3 = findViewById(R.id.layout3);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        respuesta4 = findViewById(R.id.respuesta4);
        layout4 = findViewById(R.id.layout4);
        layout4.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        respuesta5 = findViewById(R.id.respuesta5);
        layout5 = findViewById(R.id.layout5);
        layout5.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        respuesta6 = findViewById(R.id.respuesta6);
        layout6 = findViewById(R.id.layout6);
        layout6.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);


        // Casa
        casa = findViewById(R.id.imageButton7);

        casa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent casa = new Intent(InfoActivity.this, Perfil_Usuario.class);
                casa.putExtra("idUsuario", idUsuario);
                startActivity(casa);
            }
        });

        // Mapa
        mapa = findViewById(R.id.imageButton12);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mapa = new Intent(InfoActivity.this, MapsActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                startActivity(mapa);
            }
        });

        // Scaner
        escaner = findViewById(R.id.imageButton13);

        escaner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent escaner = new Intent(InfoActivity.this, ScanerActivity.class);
                escaner.putExtra("idUsuario", idUsuario);
                startActivity(escaner);
            }
        });

        // Ranking
        ranking = findViewById(R.id.imageButton14);

        ranking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ranking = new Intent(InfoActivity.this, RankingActivity.class);
                ranking.putExtra("idUsuario", idUsuario);
                startActivity(ranking);
            }
        });

        // Informacion
        informacion = findViewById(R.id.imageButton15);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent informacion = new Intent(InfoActivity.this, InfoActivity.class);
                informacion.putExtra("idUsuario", idUsuario);
                startActivity(informacion);
            }
        });

    }

    public void expand(View view) {
        int v = (respuesta1.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;

        TransitionManager.beginDelayedTransition(layout1, new AutoTransition());
        respuesta1.setVisibility(v);
    }

    public void expand2(View view) {
        int i = (respuesta2.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
        respuesta2.setVisibility(i);

    }

    public void expand3(View view) {
        int k = (respuesta3.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
        respuesta3.setVisibility(k);

    }

    public void expand4(View view) {
        int k = (respuesta4.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout4, new AutoTransition());
        respuesta4.setVisibility(k);

    }

    public void expand5(View view) {
        int q = (respuesta5.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout5, new AutoTransition());
        respuesta5.setVisibility(q);

    }

    public void expand6(View view) {
        int q = (respuesta6.getVisibility() == View.GONE) ? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout6, new AutoTransition());
        respuesta6.setVisibility(q);

    }


}