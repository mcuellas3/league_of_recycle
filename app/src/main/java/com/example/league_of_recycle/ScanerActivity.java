package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanerActivity extends AppCompatActivity {

    Button BtnScan;
    EditText TxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaner);

        BtnScan = findViewById(R.id.btnScan);
        TxtResult =findViewById(R.id.TxtResult);

        BtnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrador = new IntentIntegrator(ScanerActivity.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Lector - CDP");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();


            }
        });

    }

    protected void OnActivityResult (int RequestCode, int ResultCode, Intent Data ){

        IntentResult result = IntentIntegrator.parseActivityResult(RequestCode, ResultCode, Data);

        if (result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "Lectura Cancelada", Toast.LENGTH_LONG).show();
                TxtResult.setText(result.getContents());
            }
            else{
                super.onActivityResult(RequestCode, ResultCode, Data);
            }
        }

    }
}