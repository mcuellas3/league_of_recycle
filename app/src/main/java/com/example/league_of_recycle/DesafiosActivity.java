package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class DesafiosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafios);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setTitle("MyTitle");
    }
}

    //metodo para el toolbar

