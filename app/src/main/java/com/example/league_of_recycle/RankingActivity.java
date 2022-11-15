package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class RankingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
    }

    //metodo para mostra el menu superior
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // metodo ocultar menu no funciona getItemId
    //public boolean onOptionsItemSelected(Menu item){
        //String id = item.getItemId();
        //return super.onOptionsItemSelected(item);
   // }

    // metodo boton menu casa
    public void Home(View view) {
        Intent home = new Intent(this, HomeActivity.class);
        startActivity(home);
    }

    // metodo boton menu mapa
    public void Map(View view) {
        Intent map = new Intent(this, MapsActivity.class);
        startActivity(map);
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