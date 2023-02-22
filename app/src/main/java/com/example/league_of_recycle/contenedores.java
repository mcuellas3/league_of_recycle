package com.example.league_of_recycle;

import com.google.android.gms.maps.model.LatLng;

public class contenedores {

    private Integer id_centro = 0;
    private String tipo = "";
    private LatLng lat = null;
    private LatLng lon = null;
    private String qr = null;

    public contenedores(Integer id_centro, String tipo, LatLng lat,LatLng lon, String qr) {
        this.id_centro = id_centro;
        this.tipo = tipo;
        this.lat = lat;
        this.lon = lon;
        this.qr = qr;
    }

    public contenedores() {
        this.id_centro = 0;
        this.tipo = "";
        this.lat = null;
        this.lon = null;
        this.qr = null;
    }

    public Integer getId_centro() {
        return id_centro;
    }

    public String getTipo() {
        return tipo;
    }

    public String getQr() {
        return qr;
    }

    public void setId_centro(Integer id_centro) {
        this.id_centro = id_centro;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public LatLng getLat() {
        return lat;
    }

    public LatLng getLon() {
        return lon;
    }

    public void setLat(LatLng lat) {
        this.lat = lat;
    }

    public void setLon(LatLng lon) {
        this.lon = lon;
    }
}
