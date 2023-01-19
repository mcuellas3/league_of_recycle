package com.example.league_of_recycle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import java.sql.Array;

public class SQLiteConexion extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Recycle_DB";
    private static final String DATABASE_TABLE_USUARIOS = "usuarios";
    private static final int DATABASE_VERSION = 1;

    private final String KEY_ID_USUARIO = "id_usuario";
    private final String KEY_NOMBRE = "nombre";
    private final String KEY_APELLIDOS = "apellidos";
    private final String KEY_EMAIL = "email";
    private final String KEY_PASS = "pass";


    private SQLiteDatabase ourDatabase;
    private final Context ourContext;


    public SQLiteConexion(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ourContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + DATABASE_TABLE_USUARIOS + " (" +
                KEY_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NOMBRE + " TEXT NOT NULL, " +
                KEY_APELLIDOS + " TEXT NOT NULL, " +
                KEY_EMAIL + " TEXT NOT NULL, " +
                KEY_PASS + " TEXT NOT NULL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USUARIOS);
        onCreate(db);
    }

    public SQLiteConexion open() throws SQLException {
        this.ourDatabase = this.getWritableDatabase();
        return this;
    }

    public void close() {
        super.close();
    }

    public int login (String Usuario, String pass){
       this.open();
        String[] columnas = new String[] {KEY_ID_USUARIO};

        String selection = KEY_EMAIL + " = ? and " + KEY_PASS + " = ?" ;

        String[] selectionArgs = new String[] { Usuario, pass };

        Cursor c = this.ourDatabase.query(DATABASE_TABLE_USUARIOS, columnas,selection,selectionArgs,null,null,null,null);

        int iid_usuario = c.getColumnIndex(KEY_ID_USUARIO);
        int id_usuario=0;
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            id_usuario = c.getInt(iid_usuario);
        }
        return id_usuario;
    }

    public Usuarios getUser (int idUsuario){
        this.open();
        Usuarios usuario = new Usuarios();

        String[] columnas = new String[] {KEY_ID_USUARIO,KEY_NOMBRE,KEY_APELLIDOS,KEY_EMAIL,KEY_PASS};
        String selection = KEY_ID_USUARIO + " = ?";
        String[] selectionArgs = new String[] { String.valueOf(idUsuario) };

        Cursor c = this.ourDatabase.query(DATABASE_TABLE_USUARIOS, columnas,selection,selectionArgs,null,null,null,null);
        boolean val =false;
        int iid_usuario = c.getColumnIndex(KEY_ID_USUARIO);
        int inombre = c.getColumnIndex(KEY_NOMBRE);
        int iapellidos = c.getColumnIndex(KEY_APELLIDOS);
        int iemail = c.getColumnIndex(KEY_EMAIL);
        int ipass = c.getColumnIndex(KEY_PASS);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            usuario.setId_usuario(c.getInt(iid_usuario));
            usuario.setNombre(c.getString(inombre));
            usuario.setApellidos(c.getString(iapellidos));
            usuario.setEmail(c.getString(iemail));
            usuario.setPass(c.getString(ipass));
        }

        return usuario;
    }

    public boolean checkUserByName (String Usuario){
        this.open();
        String[] columnas = new String[] {KEY_ID_USUARIO};
        String selection = KEY_EMAIL + " = ?" ;
        String[] selectionArgs = new String[] { Usuario };
        Cursor c = this.ourDatabase.query(DATABASE_TABLE_USUARIOS, columnas,selection,selectionArgs,null,null,null,null);
        boolean val =false;
        if (!c.isAfterLast()){
            val=true;
        }
        return val;
    }

    public Long guardarUsuario(String nombre, String apellidos, String email, String pass) {
        this.open();
        long codigoInsert=0;

        try {
            ContentValues cv = new ContentValues();
            cv.put(KEY_NOMBRE, nombre);
            cv.put(KEY_APELLIDOS, apellidos);
            cv.put(KEY_EMAIL, email);
            cv.put(KEY_PASS, pass);
            codigoInsert = this.ourDatabase.insert(DATABASE_TABLE_USUARIOS, null,cv);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return codigoInsert;
    }

    public ArrayList<Usuarios> getUsuarios() {
        this.open();
        String[] columnas = new String[] {KEY_ID_USUARIO, KEY_NOMBRE, KEY_APELLIDOS, KEY_EMAIL, KEY_PASS};
        Cursor c = this.ourDatabase.query(DATABASE_TABLE_USUARIOS, columnas,null,null,null,null,null,null);

        ArrayList<Usuarios> resultado = new ArrayList<Usuarios>();

        int iid_usuario = c.getColumnIndex(KEY_ID_USUARIO);
        int inombre = c.getColumnIndex(KEY_NOMBRE);
        int iapellidos = c.getColumnIndex(KEY_APELLIDOS);
        int iemail = c.getColumnIndex(KEY_EMAIL);
        int icontraseña = c.getColumnIndex(KEY_PASS);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            Integer id_usuario = c.getInt(iid_usuario);
            String nombre = c.getString(inombre);
            String apellidos = c.getString(iapellidos);
            String email = c.getString(iemail);
            String contraseña = c.getString(icontraseña);

            Usuarios usuario = new Usuarios(nombre, apellidos, email, contraseña);
            resultado.add(usuario);
        }
        c.close();
        this.close();
        return resultado;
    }

    public ArrayList<Usuarios> getUsuario() {
        this.open();
        String[] columnas = new String[] {KEY_ID_USUARIO, KEY_NOMBRE, KEY_APELLIDOS, KEY_EMAIL, KEY_PASS};
        Cursor c = this.ourDatabase.query(DATABASE_TABLE_USUARIOS, columnas,null,null,null,null,null,null);

        ArrayList<Usuarios> resultado = new ArrayList<Usuarios>();

        int iid_usuario = c.getColumnIndex(KEY_ID_USUARIO);
        int inombre = c.getColumnIndex(KEY_NOMBRE);
        int iapellidos = c.getColumnIndex(KEY_APELLIDOS);
        int iemail = c.getColumnIndex(KEY_EMAIL);
        int ipass = c.getColumnIndex(KEY_PASS);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            Integer id_usuario = c.getInt(iid_usuario);
            String nombre = c.getString(inombre);
            String apellidos = c.getString(iapellidos);
            String email = c.getString(iemail);
            String contraseña = c.getString(ipass);

            Usuarios usuario = new Usuarios(nombre, apellidos, email, contraseña);
            resultado.add(usuario);
        }
        c.close();
        this.close();
        return resultado;
    }

}

