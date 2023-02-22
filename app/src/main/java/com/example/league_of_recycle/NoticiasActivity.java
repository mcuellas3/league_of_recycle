package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NoticiasActivity extends AppCompatActivity {

    TextView noticia1, noticia2, noticia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        noticia1 = findViewById(R.id.tv_infonot1);
        noticia2 = findViewById(R.id.tv_infonot2);
        noticia3 = findViewById(R.id.tv_infonot3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        noticia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.libremercado.com/2023-02-13/bruselas-prepara-impuestos-a-los-productos-nuevos-para-forzar-a-usar-plasticos-o-textiles-reciclados-6984748/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });

        noticia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.lavanguardia.com/economia/20230214/8754504/andorra-tendra-reciclaje-urbano-residuos-65-2035-brl.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });

        noticia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.eldiario.es/consumoclaro/consumo-sostenible/sistema-aleman-devolucion-botellas-latas-mejor-contenedores-reciclaje_1_9926617.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });

    }
}
