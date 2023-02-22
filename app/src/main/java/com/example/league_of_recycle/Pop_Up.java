package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Pop_Up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        Bundle b = this.getIntent().getExtras();
        int idUsuario = b.getInt("idUsuario");


        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);



        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.85), (int)(alto * 0.34));
        LinearLayout popup = (LinearLayout) findViewById(R.id.Popup);
        popup.setVisibility(View.VISIBLE);



        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pop_Up.this, Perfil_Usuario.class);
                intent.putExtra("idUsuario",idUsuario);
                startActivity(intent);
                finish();
            }
        });



    }
}