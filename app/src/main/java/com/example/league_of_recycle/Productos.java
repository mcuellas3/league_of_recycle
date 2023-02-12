package com.example.league_of_recycle;

public class Productos {
    private Integer id_producto = 0;
    private String marca = "";
    private String nombre = "";
    private String envase = "";
    private String codigo = "";
    private String categoria = "";
    private Integer puntos = 0;
    private Integer altura = 0;
    private Integer peso = 0;

    public Productos(Integer id_producto, String marca, String nombre, String envase, String codigo, String categoria, Integer puntos, Integer altura, Integer peso) {
        this.id_producto = id_producto;
        this.marca = marca;
        this.nombre = nombre;
        this.envase = envase;
        this.codigo = codigo;
        this.categoria = categoria;
        this.puntos = puntos;
        this.altura = altura;
        this.peso = peso;
    }

    public Productos() {
        this.id_producto = id_producto;
        this.marca = "";
        this.nombre = "";
        this.envase = "";
        this.codigo = "";
        this.categoria = "";
        this.puntos = 0;
        this.altura = 0;
        this.peso = 0;
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

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getCategoria() {
        return categoria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }
}
