package com.example.league_of_recycle;

public class Usuarios {
    private Integer id_usuario = 0;
    private String nombre = "";
    private String apellidos = "";
    private String email = "";
    private String pass = "";
    private String telefono = "";
    private int id_centro = 0;
    private boolean is_admin = false;


    public Usuarios( String nombre, String apellidos, String email, String pass) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.pass = pass;
        this.telefono = "";
        this.id_centro = 0;
    }

    public Usuarios( String nombre, String apellidos, String email, String pass, boolean is_admin) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.pass = pass;
        this.is_admin = is_admin;
        this.telefono = "";
        this.id_centro = 0;
    }

    public Usuarios() {
        this.nombre = "";
        this.apellidos = "";
        this.email = "";
        this.pass = "";
        this.telefono = "";
        this.id_centro = 0;
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

    public String getPass() { return pass; }
					
	 

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getId_centro() { return id_centro; }

    public void setId_centro(int id_centro) { this.id_centro = id_centro; }

    public boolean getIs_admin() { return is_admin; }

    public void setIs_admin(boolean is_admin) { this.is_admin = is_admin; }
}
