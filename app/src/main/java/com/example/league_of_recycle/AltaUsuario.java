package com.example.league_of_recycle;

import android.util.Log;

import com.example.league_of_recycle.Usuarios;
import androidx.appcompat.app.AppCompatActivity;
import com.example.league_of_recycle.SQLiteConexion;


public class AltaUsuario extends AppCompatActivity {


    String nombre = "";
    String apellidos = "";
    String email = "";
    String pass = "";
    boolean is_admin = false;
    Usuarios usuario = new Usuarios(nombre, apellidos, email, pass, is_admin);

    SQLiteConexion db = new SQLiteConexion(AltaUsuario.this);

    Long usercode = db.guardarUsuario(usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getPass(), false);

}
