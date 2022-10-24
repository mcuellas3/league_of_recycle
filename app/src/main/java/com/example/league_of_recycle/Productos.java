package com.example.league_of_recycle;

public class Productos {
    private Integer id_producto = 0;
    private String nombre = "";
    private String envase = "";
    private Integer codigo = 0;
    private Integer puntos = 0;
    private Integer altura = 0;
    private Integer peso = 0;

    public Productos(Integer id_producto, String nombre, String envase, Integer codigo, Integer puntos, Integer altura, Integer peso) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.envase = envase;
        this.codigo = codigo;
        this.puntos = puntos;
        this.altura = altura;
        this.peso = peso;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnvase() {
        return envase;
    }

    public void setEnvase(String envase) {
        this.envase = envase;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
