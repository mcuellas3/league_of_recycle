package com.example.league_of_recycle;

public class Productos {
    private Integer id_producto = 0;
    private String marca = "";
    private String nombre = "";
    private String cantidad = "";
    private String envase = "";
    private String codigo = "";
    private String categoria = "";
    private String degrad = "";
    private String puntos = "";
    private Integer huella = 0;
    private Integer peso = 0;
    private String greendot = "";


    public Productos(Integer id_producto, String marca, String nombre, String cantidad, String envase, String codigo, String categoria, String degrad, String puntos, Integer altura, Integer peso) {
        this.id_producto = id_producto;
        this.marca = marca;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.envase = envase;
        this.codigo = codigo;
        this.categoria = categoria;
        this.degrad = degrad;
        this.puntos = puntos;
        this.huella = altura;
        this.peso = peso;

    }

    public Productos() {
        this.id_producto = id_producto;
        this.marca = "";
        this.nombre = "";
        this.cantidad = "";
        this.envase = "";
        this.codigo = "";
        this.categoria = "";
        this.degrad = "";
        this.puntos = "";
        this.huella = 0;
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

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public Integer getHuella() {
        return huella;
    }

    public void setHuella(Integer huella) {
        this.huella = huella;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDegrad() {
        return degrad;
    }

    public void setDegrad(String degrad) {
        this.degrad = degrad;
    }

    public String getGreendot() {
        return greendot;
    }

    public void setGreendot(String greendot) {
        this.greendot = greendot;
    }
}
