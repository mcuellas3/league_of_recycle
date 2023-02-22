package com.example.league_of_recycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProductosActivity extends AppCompatActivity {

    TextView  marca, nombre, cantidad, envase, huella, degradacion, material, puntos;
    Button reciclar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Bundle b = this.getIntent().getExtras();
        String codigo=b.getString("codigo");
        int idUsuario=b.getInt("idUsuario");

        marca = (TextView) findViewById(R.id.prodMarca);
        nombre = (TextView) findViewById(R.id.prodNombre);
        cantidad = (TextView) findViewById(R.id.prodCantidad);
        envase = (TextView) findViewById(R.id.prodEnvase);
        degradacion = (TextView) findViewById(R.id.prodDegrad);
        puntos = (TextView) findViewById(R.id.prodPuntos);
        huella =(TextView) findViewById(R.id.txthuella);

        reciclar = (Button) findViewById(R.id.btnReciclar);



        SQLiteConexion db = new SQLiteConexion(this);
        Productos producto = db.getProducto(codigo);
        marca.setText(producto.getMarca());
        nombre.setText(producto.getNombre());
        cantidad.setText(producto.getCantidad());
        envase.setText(producto.getEnvase());
        huella.setText("Reciclando este producto reduces la huella de carbono en " + producto.getHuella() + "Kg CO2eq");
        degradacion.setText("Este producto tardara" + producto.getDegrad());
        puntos.setText(producto.getPuntos());

        reciclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues cv = new ContentValues();
                cv.put("id_usuario", idUsuario);
                cv.put("id_producto",producto.getId_producto());
                db.insertar("puntos",cv);

                Intent escaner = new Intent(ProductosActivity.this, ScanerActivity.class);
                escaner.putExtra("idUsuario", idUsuario);
                startActivity(escaner);

            }
        });

    }
}