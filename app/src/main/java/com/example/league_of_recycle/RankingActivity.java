package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    String idUsuario = getIntent().getStringExtra("idUsuario"); //pasamos el usuario entre activitys
    List<ListRanking> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        init();
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
   //


    //Metodo para mostrar la lista del ranking

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListRanking("manuel", "1500",""));

        RankingListAdapter RankinglistAdapter = new RankingListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listaRanking);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(RankinglistAdapter);
    }


}