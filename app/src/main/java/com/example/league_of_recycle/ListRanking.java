package com.example.league_of_recycle;

public class ListRanking {

    public String nombre;
    public String puntos;
    public String foto;

    public ListRanking(String nombre, String puntos, String foto) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
