package com.example.league_of_recycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    List<ListRanking> topelements, elements;
    TextView pos1, pos2, pos3, nom1, nom2, nom3, punt1, punt2, punt3;
    ImageButton casa, mapa, escaner, ranking, informacion;
    Button premios;
    int idUsuario;
    SQLiteConexion db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        premios =(Button) findViewById(R.id.premTabPremios);
        pos1 =(TextView) findViewById(R.id.tvPos1);
        pos2=(TextView) findViewById(R.id.tvPos2);
        pos3 =(TextView) findViewById(R.id.tvPos3);
        nom1 =(TextView) findViewById(R.id.tvNombreRank1);
        nom2 =(TextView) findViewById(R.id.tvNombreRank2);
        nom3 =(TextView) findViewById(R.id.tvNombreRank3);
        punt1 =(TextView) findViewById(R.id.tvPuntosRank1);
        punt2 =(TextView) findViewById(R.id.tvPuntosRank2);
        punt3 =(TextView) findViewById(R.id.tvPuntosRank3);


        this.db = new SQLiteConexion(this);
        Bundle b = this.getIntent().getExtras();
        this.idUsuario=b.getInt("idUsuario");

        init();

        premios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tab = new Intent(RankingActivity.this, PremiosActivity.class);
                tab.putExtra("idUsuario", idUsuario);
                startActivity(tab);
            }
        });

        // Casa
        casa = findViewById(R.id.imageButton7);

        casa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent casa = new Intent(RankingActivity.this, HomeActivity.class);
                casa.putExtra("idUsuario", idUsuario);
                startActivity(casa);
            }
        });

        // Mapa
        mapa = findViewById(R.id.imageButton12);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mapa = new Intent(RankingActivity.this, MapsActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                startActivity(mapa);
            }
        });

        // Scaner
        escaner = findViewById(R.id.imageButton13);

        escaner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent escaner = new Intent(RankingActivity.this, ScanerActivity.class);
                escaner.putExtra("idUsuario", idUsuario);
                startActivity(escaner);
            }
        });

        // Ranking
        ranking = findViewById(R.id.imageButton14);

        ranking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ranking = new Intent(RankingActivity.this, RankingActivity.class);
                ranking.putExtra("idUsuario", idUsuario);
                startActivity(ranking);
            }
        });

        // Informacion
        informacion = findViewById(R.id.imageButton15);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent informacion = new Intent(RankingActivity.this, InfoActivity.class);
                informacion.putExtra("idUsuario", idUsuario);
                startActivity(informacion);
            }
        });
    }

    //metodo para mostra el menu superior
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }
    // metodo ocultar menu no funciona getItemId
    //public boolean onOptionsItemSelected(Menu item){
        //String id = item.getItemId();
        //return super.onOptionsItemSelected(item);
   //

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Bundle b = this.getIntent().getExtras();
        int idUsuario = b.getInt("idUsuario");

        switch ((item.getItemId())) {
            case R.id.item1:
                Usuarios usuario = db.getUser(idUsuario);

                if (!usuario.getIs_admin()) {
                    Intent perfil = new Intent(RankingActivity.this, Perfil_Usuario.class);
                    perfil.putExtra("idUsuario", idUsuario);
                    startActivity(perfil);
                } else {
                    Intent perfil = new Intent(RankingActivity.this, PerfilAdminActivity.class);
                    perfil.putExtra("idUsuario", idUsuario);
                    startActivity(perfil);
                }
                return true;

            case R.id.item2:
                Intent login = new Intent(RankingActivity.this, MainActivity.class);
                startActivity(login);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Metodo para mostrar la lista del ranking

    public void init(){

        elements = new ArrayList<>();
        topelements = new ArrayList<>();
        Usuarios usuario = db.getUser(this.idUsuario);

        elements=this.db.getRanking(usuario.getCentro());

        int i;
        ListRanking  item;
        for (i=0;i<3;i++){
            topelements.add(elements.get(0));
            elements.remove(0);
        }

        if (i==3) {
            item = topelements.get(0);
            pos1.setText(item.getPosicion());
            nom1.setText(item.getNombre());
            punt1.setText(item.getPuntos());
            item = topelements.get(1);
            pos2.setText(item.getPosicion());
            nom2.setText(item.getNombre());
            punt2.setText(item.getPuntos());
            item = topelements.get(2);
            pos3.setText(item.getPosicion());
            nom3.setText(item.getNombre());
            punt3.setText(item.getPuntos());
        }

            RankingListAdapter RankinglistAdapter = new RankingListAdapter(elements, this);
            RecyclerView recyclerView = findViewById(R.id.recyclerRanking);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(RankinglistAdapter);
    }


}