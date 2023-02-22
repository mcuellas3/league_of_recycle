package com.example.league_of_recycle;

import com.google.android.gms.maps.model.LatLng;

public class contenedores {

    private Integer id_centro = 0;
    private String tipo = "";
    private LatLng coordenadas = null;
    private String qr = null;

    public contenedores(Integer id_centro, String tipo, LatLng coordenadas, String qr) {
        this.id_centro = id_centro;
        this.tipo = tipo;
        this.coordenadas = coordenadas;
        this.qr = qr;
    }

    public contenedores() {
        this.id_centro = 0;
        this.tipo = "";
        this.coordenadas = null;
        this.qr = null;
    }

    public Integer getId_centro() {
        return id_centro;
    }

    public String getTipo() {
        return tipo;
    }

    public LatLng getCoordenadas() {
        return coordenadas;
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

    public void setCoordenadas(LatLng coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
}
