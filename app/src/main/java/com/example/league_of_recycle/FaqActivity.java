package com.example.league_of_recycle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FaqActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> preguntaFaq = new ArrayList<>();
    private ArrayList<String> respuesta = new ArrayList<>();



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


}