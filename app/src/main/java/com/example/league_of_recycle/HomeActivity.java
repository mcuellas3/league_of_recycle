package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

        // metodo boton menu casa
        public void Home(View view) {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }

        // metodo boton menu mapa
        public void Map(View view) {

            Intent i = new Intent(this, MapsActivity.class);

            startActivity(i);
        }

        // metodo boton menu scaner
        public void Scan(View view) {
            Intent scan = new Intent(this, ScanerActivity.class);
            startActivity(scan);
        }

        // metodo boton menu ranking
        public void Ranking(View view) {
            Intent ranking = new Intent(this, RankingActivity.class);
            startActivity(ranking);
        }

        // metodo boton menu info
        public void Info(View view) {
            Intent info = new Intent(this, InfoActivity.class);
            startActivity(info);
        }
}