package com.example.league_of_recycle;

public class Usuarios {
    private Integer id_usuario = 0;
    private String nombre = "";
    private String apellidos = "";
    private String email = "";
    private String pass = "";


    public Usuarios( String nombre, String apellidos, String email, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.pass = pass;
    }

    public Integer getId_usuario() { return id_usuario; }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
