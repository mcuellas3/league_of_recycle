package com.example.league_of_recycle;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.league_of_recycle.databinding.ActivityMapsSelectBinding;

public class MapsSelectActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsSelectBinding binding;
    LatLng coordenadas;
    SQLiteConexion db;
    Context context;
    int id_centro;
    String loclat, loclong;
    int idUsuario;
    String tipo, ubicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMapsSelectBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle b = this.getIntent().getExtras();
        idUsuario=b.getInt("idUsuario");
        ubicar = b.getString("ubicar");
        tipo = b.getString("tipo");

        context = this;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //mMap.getCameraPosition();
        LatLng predeter = new LatLng(40.42026,-3.69756 );
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(predeter, 12.1f));

        if (this.tipo=="ubicacion") {

            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                @Override
                public void onMapClick(@NonNull LatLng position) {
                    coordenadas = position;

                    insertarMarcador(position);
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:

                                    db = new SQLiteConexion(context);
                                    Usuarios usuario = db.getUser(idUsuario);
                                    Centros centro = db.getCentro(usuario.getCentro());

                                    loclat = String.valueOf(coordenadas.latitude);
                                    loclong = String.valueOf(coordenadas.longitude);


                                    ContentValues cv = new ContentValues();
                                    cv.put("lat", (loclat));
                                    cv.put("lon", (loclong));
                                    String selection = "id_centro = ?";
                                    String[] selectionArgs = new String[]{String.valueOf(centro.getId_centro())};

                                    db.actualizar("centros", cv, selection, selectionArgs);

                                    Intent perfil = new Intent(MapsSelectActivity.this, PerfilAdminActivity.class);
                                    perfil.putExtra("idUsuario", idUsuario);
                                    startActivity(perfil);

                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    mMap.clear();
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("¿Quieres confirmar esta ubicación?").setPositiveButton("Si", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();

                }

            });

        }else{
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                @Override
                public void onMapClick(@NonNull LatLng position) {
                    coordenadas = position;

                    insertarMarcador(position);
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:

                                    db = new SQLiteConexion(context);
                                    Usuarios usuario = db.getUser(idUsuario);
                                    Centros centro = db.getCentro(usuario.getCentro());

                                    loclat = String.valueOf(coordenadas.latitude);
                                    loclong = String.valueOf(coordenadas.longitude);


                                    ContentValues cv = new ContentValues();
                                    cv.put("id_centro", (centro.getId_centro()));
                                    cv.put("tipo", (tipo));
                                    cv.put("lat", (loclat));
                                    cv.put("lon", (loclong));
                                    String selection = "id_centro = ?";
                                    String[] selectionArgs = new String[]{String.valueOf(centro.getId_centro())};

                                    db.insertar("contenedores", cv);

                                    Intent perfil = new Intent(MapsSelectActivity.this, PerfilAdminActivity.class);
                                    perfil.putExtra("idUsuario", idUsuario);
                                    startActivity(perfil);

                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    mMap.clear();
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("¿Quieres confirmar esta ubicación?").setPositiveButton("Si", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();

                }

            });

        }
    }

    private void insertarMarcador(LatLng position){
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(position).title("marcador"));
    }
}