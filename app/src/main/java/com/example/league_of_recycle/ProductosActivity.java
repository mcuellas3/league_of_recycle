package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProductosActivity extends AppCompatActivity {

    TextView nombre, marca, envase, material;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Bundle b = this.getIntent().getExtras();
        String codigo=b.getString("codigo");

        marca = (TextView) findViewById(R.id.prodMarca);
        nombre = (TextView) findViewById(R.id.prodNombre);

        SQLiteConexion db = new SQLiteConexion(this);
        Productos producto = db.getProducto(codigo);
        marca.setText(producto.getMarca());
        nombre.setText(producto.getNombre());


    }


}