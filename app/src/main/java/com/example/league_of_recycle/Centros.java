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
    private String direccion = "";
    private String telefono = "";
    private ArrayList geo[];


    public Centros() {
        this.centro = "";
        this.id_responsable=0;
        this.locLat="";
        this.locLong="";
        this.direccion = "";
        this.telefono = "";

    }

    public Centros(int centro, int id_responsable) {
        this.id_centro = centro;
        this.id_responsable=id_responsable;

    }

    public Integer getId_centro() { return id_centro; }

    public void setId_centro(Integer id_usuario) {
        this.id_centro = id_usuario;
    }

    public String getNombre() {
        return centro;
    }

    public void setNombre(String nombre) {
        this.centro = nombre;
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

    public String getCentro() {
        return centro;
    }

    public Integer getId_responsable() {
        return id_responsable;
    }

    public Usuarios getResponsable() {
        return responsable;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public void setId_responsable(Integer id_responsable) {
        this.id_responsable = id_responsable;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
