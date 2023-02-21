package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PremiosActivity extends AppCompatActivity {


    Button ranking;
    int idUsuario;

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
    }
}