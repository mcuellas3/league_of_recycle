package com.example.league_of_recycle;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.league_of_recycle.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Double lat;
    Double lon;
    String Nombre;
    String centro;
    ArrayList<contenedores> cont;
																									

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        SQLiteConexion db  = new SQLiteConexion(this);
        Bundle b = this.getIntent().getExtras();
        int idUsuario=b.getInt("idUsuario");

        Usuarios usuario = db.getUser(idUsuario);
        Centros centro = db.getCentro(usuario.getCentro());



        mMap = googleMap;
        // añade marcador instituto usuario
        LatLng instituto = new LatLng(Double.valueOf(centro.getLocLat()), Double.valueOf(centro.getLocLong()));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.addMarker(new MarkerOptions().position(instituto).title(centro.getCentro()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(instituto, 20.01f));

        cont = db.getContenedores(usuario.getCentro());

        for (contenedores c:cont) {

            lat=(Double.valueOf(c.getLat()));
            lon=(Double.valueOf(c.getLon()));
            LatLng pos = new LatLng(lat,lon);
            mMap.addMarker(new MarkerOptions().position(pos));
        }
    }
}