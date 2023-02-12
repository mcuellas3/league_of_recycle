package com.example.league_of_recycle;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Centros {
    private Integer id_centro = 0;
    private String centro = "";
    private Integer id_responsable = 0;
    private Usuarios responsable;
    private String locLat = "";
    private String locLong = "";
    private ArrayList geo[];


    public Centros() {
        this.centro = "";
        this.id_responsable=0;
        this.locLat="";
        this.locLong="";
    }

    public Centros(int centro, int id_responsable) {
        this.id_centro = centro;
        this.centro=this.getNombre(centro);
        this.id_responsable=id_responsable;
        this.responsable=getResponsable(id_responsable);

    }

    public Integer getId_usuario() { return id_centro; }

    public void setId_usuario(Integer id_usuario) {
        this.id_centro = id_usuario;
    }

    public String getNombre(int id_centro) {
        return centro;
    }

    public void setNombre(String nombre) {
        this.centro = nombre;
    }

    public Usuarios getResponsable(int id_responsable) {


        return responsable;
    }

    public void setResponsable(Usuarios responsable) {
        this.responsable = responsable;
    }

    public String getLocLat() {
        return locLat;
    }

    public String getLocLong() {
        return locLong;
    }

    public ArrayList[] getGeo() {
        return geo;
    }

    public void setLocLat(String locLat) {
        this.locLat = locLat;
    }

    public void setLocLong(String locLong) {
        this.locLong = locLong;
    }

    public void setGeo(ArrayList[] geo) {
        this.geo = geo;
    }
}
