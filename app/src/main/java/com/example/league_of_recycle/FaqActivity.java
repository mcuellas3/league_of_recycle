package com.example.league_of_recycle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FaqActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> preguntaFaq = new ArrayList<>();
    private ArrayList<String> respuesta = new ArrayList<>();
    SQLiteConexion db;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(FaqActivity.this));

        preguntaFaq.add("Hola que tal?");
        preguntaFaq.add("Esto funciona?");

        respuesta.add("Bien y vos?");
        respuesta.add("Parece que no");

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        switch ((item.getItemId())){
            case R.id.item1:
                Usuarios usuario = db.getUser(idUsuario);

                if (usuario.getIs_admin()){
                    Intent perfil = new Intent(FaqActivity.this, Perfil_Usuario.class);
                    perfil.putExtra("idUsuario", idUsuario);
                    startActivity(perfil);
                }else {
                    Intent perfil = new Intent(FaqActivity.this, Perfil_Usuario.class);
                    perfil.putExtra("idUsuario", idUsuario);
                    startActivity(perfil);
                }
                return true;

            case R.id.item2:
                Intent login = new Intent(FaqActivity.this, MainActivity.class);
                startActivity(login);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}