package com.example.league_of_recycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanerActivity extends AppCompatActivity {

    Button BtnScan;
    EditText TxtResult;
    ImageButton casa, mapa, escaner, ranking, informacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaner);
        SQLiteConexion db = new SQLiteConexion(this);
        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        BtnScan = findViewById(R.id.btnScan);
        TxtResult = findViewById(R.id.TxtResult);
        IntentIntegrator integrador = new IntentIntegrator(ScanerActivity.this);

        // Casa
        casa = findViewById(R.id.imageButton7);

        casa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Usuarios usuario = db.getUser(idUsuario);

                if (usuario.getIs_admin()){
                    Intent casa = new Intent(ScanerActivity.this, Perfil_Usuario_AdminActivity.class);
                    casa.putExtra("idUsuario", idUsuario);
                    startActivity(casa);
                }else {
                    Intent casa = new Intent(ScanerActivity.this, Perfil_Usuario.class);
                    casa.putExtra("idUsuario", idUsuario);
                    startActivity(casa);
                }
            }
        });

        // Mapa
        mapa = findViewById(R.id.imageButton12);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mapa = new Intent(ScanerActivity.this, MapsActivity.class);
                mapa.putExtra("idUsuario", idUsuario);
                startActivity(mapa);
            }
        });

        // Scaner
        escaner = findViewById(R.id.imageButton13);

        escaner.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent escaner = new Intent(ScanerActivity.this, ScanerActivity.class);
                escaner.putExtra("idUsuario", idUsuario);
                startActivity(escaner);
            }
        });

        // Ranking
        ranking = findViewById(R.id.imageButton14);

        ranking.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ranking = new Intent(ScanerActivity.this, RankingActivity.class);
                ranking.putExtra("idUsuario", idUsuario);
                startActivity(ranking);
            }
        });

        // Informacion
        informacion = findViewById(R.id.imageButton15);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent informacion = new Intent(ScanerActivity.this, InfoActivity.class);
                informacion.putExtra("idUsuario", idUsuario);
                startActivity(informacion);
            }
        });


        BtnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TxtResult.getText().toString().equals("")){
                    integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                    integrador.setPrompt("Lector - CDP");
                    integrador.setCameraId(0);
                    integrador.setBeepEnabled(true);
                    integrador.setBarcodeImageEnabled(true);
                    integrador.initiateScan();

                }else{
                    String codigo = TxtResult.getText().toString();
                    Intent producto = new Intent(ScanerActivity.this, ProductosActivity.class);
                    producto.putExtra("codigo", codigo);
                    startActivity(producto);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Lectura Cancelada", Toast.LENGTH_LONG).show();
                TxtResult.setText(result.getContents());

            } else {
                TxtResult.setText(result.getContents());
                String codigo = TxtResult.getText().toString();
                Intent producto = new Intent(ScanerActivity.this, ProductosActivity.class);
                producto.putExtra("codigo", codigo);
                startActivity(producto);

                super.onActivityResult(requestCode, resultCode, data);
            }
        }

    }
}

