package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    List<ListRanking> elements;
    ImageButton casa, mapa, escaner, ranking, informacion;

    SQLiteConexion db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        String idUsuario = getIntent().getStringExtra("idUsuario"); //pasamos el usuario entre activitys

         this.db = new SQLiteConexion(this);
        Bundle b = this.getIntent().getExtras();
        int idUser=b.getInt("idUsuario");

        init();

        // Casa
        casa = findViewById(R.id.imageButton7);

        casa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Usuarios usuario = db.getUser(idUser);

                if (usuario.getIs_admin()){
                    Intent casa = new Intent(RankingActivity.this, Perfil_Usuario_AdminActivity.class);
                    casa.putExtra("idUsuario", idUser);
                    startActivity(casa);
                }else {
                    Intent casa = new Intent(RankingActivity.this, Perfil_Usuario.class);
                    casa.putExtra("idUsuario", idUser);
                    startActivity(casa);
                }
            }
        });

        // Mapa
        mapa = findViewById(R.id.imageButton12);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mapa = new Intent(RankingActivity.this, MapsActivity.class);
                mapa.putExtra("idUsuario", idUser);
                startActivity(mapa);
            }
        });

        // Scaner
        escaner = findViewById(R.id.imageButton13);

        escaner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent escaner = new Intent(RankingActivity.this, ScanerActivity.class);
                escaner.putExtra("idUsuario", idUser);
                startActivity(escaner);
            }
        });

        // Ranking
        ranking = findViewById(R.id.imageButton14);

        ranking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ranking = new Intent(RankingActivity.this, RankingActivity.class);
                ranking.putExtra("idUsuario", idUser);
                startActivity(ranking);
            }
        });

        // Informacion
        informacion = findViewById(R.id.imageButton15);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent informacion = new Intent(RankingActivity.this, InfoActivity.class);
                informacion.putExtra("idUsuario", idUser);
                startActivity(informacion);
            }
        });
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
        elements=this.db.getRanking();

        //elements.add(new ListRanking("manuel", "1500",""));

        RankingListAdapter RankinglistAdapter = new RankingListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerRanking);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(RankinglistAdapter);
    }


}