package com.example.league_of_recycle;
import com.example.league_of_recycle.Usuarios;
import androidx.appcompat.app.AppCompatActivity;
import com.example.league_of_recycle.SQLiteConexion;


public class AltaUsuario extends AppCompatActivity {

    String nombre = "";
    String apellidos = "";
    String email = "";
    String contraseña = "";
    Usuarios usuario = new Usuarios(nombre, apellidos, email, contraseña);

    SQLiteConexion db = new SQLiteConexion(AltaUsuario.this);

    db.guardarUsuario(usuario.getNombre(), usuario.getApellidos, usuario.getEmail, usuario.getContraseña);
}
