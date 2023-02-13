package com.example.league_of_recycle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.sql.Array;

public class SQLiteConexion extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "Recycle_DB";
    private static final String DATABASE_TABLE_USUARIOS = "usuarios";
    private static final String DATABASE_TABLE_PRODUCTOS = "productos";
    private static final String DATABASE_TABLE_CENTROS = "centros";
    private static final String DATABASE_TABLE_PUNTOS = "puntos";
    private static final String DATABASE_VIEW_RANKING = "ranking";
    private static final int DATABASE_VERSION = 1;

    private final String KEY_ID_USUARIO = "id_usuario";
    private final String KEY_NOMBRE = "nombre";
    private final String KEY_APELLIDOS = "apellidos";
    private final String KEY_EMAIL = "email";
    private final String KEY_PASS = "pass";
    private final String KEY_ISADMIN = "is_admin";
    private final String KEY_TELEFONO = "telefono";
    private final String KEY_IDCENTRO = "id_centro";

    private final String KEY_ID_PRODUCTO = "id_producto";
    private final String KEY_CODIGO = "codigo";
    private final String KEY_MARCA = "marca";
    private final String KEY_NOMBRE_PRODUCTO = "nombre";
    private final String KEY_CATEGORIA = "categoria";
    private final String KEY_CANTIDAD = "cantidad";
    private final String KEY_ENVASE = "envase";
    private final String KEY_GREENDOT = "greendot";
    private final String KEY_PUNTOS = "puntos";


    private final String KEY_ID_CENTRO = "id_centro";
    private final String KEY_NOMBRE_CENTRO = "nombre";
    private final String KEY_LOC_LON = "lon";
    private final String KEY_LOC_LAT = "lat";
    private final String KEY_RESPONSABLE = "responsable";
    private final String KEY_DIRECCION = "direccion";
    private final String KEY_TELEFONO_CENTRO = "telefono";

    private final String KEY_ID_PUNTOS = "id_puntos";
    private final String KEY_ID_USUARIO_PUNTOS = "id_usuario";
    private final String KEY_SUMAR_PUNTOS = "puntos";


    private SQLiteDatabase ourDatabase;
    private final Context ourContext;


    public SQLiteConexion(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ourContext = context;
    }

    public void callonUpgrade() {
        this.open();
        this.ourDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USUARIOS);
        onCreate(this.ourDatabase);
        this.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + DATABASE_TABLE_USUARIOS + " (" +
                KEY_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NOMBRE + " TEXT NOT NULL, " +
                KEY_APELLIDOS + " TEXT NOT NULL, " +
                KEY_EMAIL + " TEXT NOT NULL, " +
                KEY_PASS + " TEXT NOT NULL," +
                KEY_ISADMIN + " BOOLEAN NOT NULL," +
                KEY_TELEFONO + " TEXT," +
                KEY_IDCENTRO + " INTEGER);";
        db.execSQL(sql);

        sql = "CREATE TABLE " + DATABASE_TABLE_PRODUCTOS + " (" +
                KEY_ID_PRODUCTO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_CODIGO + " TEXT NOT NULL, " +
                KEY_MARCA + " TEXT NOT NULL, " +
                KEY_NOMBRE_PRODUCTO + " TEXT NOT NULL, " +
                KEY_CATEGORIA + " TEXT NOT NULL," +
                KEY_CANTIDAD + " TEXT NOT NULL," +
                KEY_ENVASE + " TEXT," +
                KEY_GREENDOT + " TEXT NOT NULL," +
                KEY_PUNTOS + " TEXT);";
        db.execSQL(sql);

        sql = "CREATE TABLE " + DATABASE_TABLE_CENTROS + " (" +
                KEY_ID_CENTRO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NOMBRE_CENTRO + " TEXT NOT NULL, " +
                KEY_LOC_LAT + " TEXT NOT NULL, " +
                KEY_LOC_LON + " TEXT NOT NULL," +
                KEY_RESPONSABLE + " TEXT NOT NULL," +
                KEY_DIRECCION + " TEXT," +
                KEY_TELEFONO_CENTRO + " TEXT NOT NULL);";
        db.execSQL(sql);

        sql = "CREATE TABLE " + DATABASE_TABLE_PUNTOS + " (" +
                KEY_ID_PUNTOS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_ID_USUARIO_PUNTOS + " INTEGER NOT NULL, " +
                KEY_SUMAR_PUNTOS + " INTEGER NOT NULL);";
        db.execSQL(sql);

        sql="create view " +DATABASE_VIEW_RANKING +" as " +
        "select nombre,sum(puntos) puntos " +
        "from puntos inner join usuarios on usuarios.id_usuario=puntos.id_usuario "  +
        "group by puntos.id_usuario " +
        "order by sum(puntos) desc";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_PRODUCTOS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CENTROS);
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_PUNTOS);
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

        String[] columnas = new String[] {KEY_ID_USUARIO,KEY_NOMBRE,KEY_APELLIDOS,KEY_EMAIL,KEY_PASS, KEY_ISADMIN,KEY_ID_CENTRO};
        String selection = KEY_ID_USUARIO + " = ?";
        String[] selectionArgs = new String[] { String.valueOf(idUsuario) };

        Cursor c = this.ourDatabase.query(DATABASE_TABLE_USUARIOS, columnas,selection,selectionArgs,null,null,null,null);
        boolean val =false;
        int iid_usuario = c.getColumnIndex(KEY_ID_USUARIO);
        int inombre = c.getColumnIndex(KEY_NOMBRE);
        int iapellidos = c.getColumnIndex(KEY_APELLIDOS);
        int iemail = c.getColumnIndex(KEY_EMAIL);
        int ipass = c.getColumnIndex(KEY_PASS);
        int iis_admin = c.getColumnIndex(KEY_ISADMIN);
        int iidCentro = c.getColumnIndex(KEY_ID_CENTRO);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            usuario.setId_usuario(c.getInt(iid_usuario));
            usuario.setNombre(c.getString(inombre));
            usuario.setApellidos(c.getString(iapellidos));
            usuario.setEmail(c.getString(iemail));
            usuario.setPass(c.getString(ipass));
            if (c.getInt(iis_admin)==0){
                usuario.setIs_admin(false);
            } else{
                usuario.setIs_admin(true);
            }
            usuario.setCentro(c.getInt(iidCentro));
        }

        return usuario;
    }

    public Productos getProducto (String codigo){
        this.open();
        Productos producto = new Productos();

        String[] columnas = new String[] {KEY_ID_PRODUCTO,KEY_CODIGO, KEY_MARCA, KEY_NOMBRE_PRODUCTO,KEY_CATEGORIA,KEY_CANTIDAD,KEY_ENVASE, KEY_PUNTOS,KEY_GREENDOT};
        String selection = KEY_CODIGO + " = ?";
        String[] selectionArgs = new String[] { String.valueOf(codigo) };

        Cursor c = this.ourDatabase.query(DATABASE_TABLE_PRODUCTOS, columnas,selection,selectionArgs,null,null,null,null);
        boolean val =false;
        int iid_producto = c.getColumnIndex(KEY_ID_PRODUCTO);
        int icodigo = c.getColumnIndex(KEY_CODIGO);
        int imarca = c.getColumnIndex(KEY_MARCA);
        int inombre = c.getColumnIndex(KEY_NOMBRE_PRODUCTO);
        int icategoria = c.getColumnIndex(KEY_CATEGORIA);
        int icantidad = c.getColumnIndex(KEY_CANTIDAD);
        int ienvase = c.getColumnIndex(KEY_ENVASE);
        int ipuntos = c.getColumnIndex(KEY_PUNTOS);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            producto.setId_producto(c.getInt(iid_producto));
            producto.setNombre(c.getString(icodigo));
            producto.setMarca(c.getString(imarca));
            producto.setNombre(c.getString(inombre));
            producto.setCategoria(c.getString(icategoria));
            producto.setCantidad(c.getString(icantidad));
            producto.setEnvase(c.getString(ienvase));
            //producto.setgreendot(c.getString(igreendot));
            producto.setPuntos(c.getString(ipuntos));
        }

        return producto;
    }

    public boolean getUserbyMail (String email){
        this.open();
        Usuarios usuario = new Usuarios();

        String[] columnas = new String[] {KEY_ID_USUARIO,KEY_NOMBRE,KEY_APELLIDOS,KEY_EMAIL,KEY_PASS, KEY_ISADMIN};
        String selection = KEY_EMAIL + " = ?";
        String[] selectionArgs = new String[] { String.valueOf(email) };
        boolean val;
        Cursor c = this.ourDatabase.query(DATABASE_TABLE_USUARIOS, columnas,selection,selectionArgs,null,null,null,null);
        if (c.getCount()<=0){
            val =false;
        } else {
            val= true;
        }
        this.close();;
        return val;
    }

    public Centros getCentro (String ncentro){
        this.open();
        Centros centro = new Centros();

        String[] columnas = new String[] {KEY_ID_CENTRO,KEY_NOMBRE_CENTRO,KEY_LOC_LAT,KEY_LOC_LON,KEY_RESPONSABLE, KEY_DIRECCION, KEY_TELEFONO_CENTRO};
        String selection = KEY_NOMBRE_CENTRO + " = ?";
        String[] selectionArgs = new String[] { String.valueOf(ncentro) };

        Cursor c = this.ourDatabase.query(DATABASE_TABLE_CENTROS, columnas,selection,selectionArgs,null,null,null,null);
        boolean val =false;
        int iid_centro = c.getColumnIndex(KEY_ID_CENTRO);
        int inombre = c.getColumnIndex(KEY_NOMBRE_CENTRO);
        int ilat = c.getColumnIndex(KEY_LOC_LAT);
        int ilon = c.getColumnIndex(KEY_LOC_LON);
        int iid_responsable = c.getColumnIndex(KEY_RESPONSABLE);
        int idireccion = c.getColumnIndex(KEY_DIRECCION);
        int itelefono = c.getColumnIndex(KEY_TELEFONO_CENTRO);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            centro.setId_centro(c.getInt(iid_centro));
            centro.setNombre(c.getString(inombre));
            centro.setLocLat(c.getString(ilat));
            centro.setLocLong(c.getString(ilon));
            centro.setId_responsable(c.getInt(iid_responsable));
            centro.setDireccion(c.getString(idireccion));
            centro.setTelefono(c.getString(itelefono));
            centro.setResponsable(getUser(centro.getId_responsable()));
        }

        return centro;
    }

    public Centros getCentro (int ncentro){
        this.open();
        Centros centro = new Centros();

        String[] columnas = new String[] {KEY_ID_CENTRO,KEY_NOMBRE_CENTRO,KEY_LOC_LAT,KEY_LOC_LON,KEY_RESPONSABLE, KEY_DIRECCION, KEY_TELEFONO_CENTRO};
        String selection = KEY_ID_CENTRO + " = ?";
        String[] selectionArgs = new String[] { String.valueOf(ncentro) };

        Cursor c = this.ourDatabase.query(DATABASE_TABLE_CENTROS, columnas,selection,selectionArgs,null,null,null,null);
        boolean val =false;
        int iid_centro = c.getColumnIndex(KEY_ID_CENTRO);
        int inombre = c.getColumnIndex(KEY_NOMBRE_CENTRO);
        int ilat = c.getColumnIndex(KEY_LOC_LAT);
        int ilon = c.getColumnIndex(KEY_LOC_LON);
        int iid_responsable = c.getColumnIndex(KEY_RESPONSABLE);
        int idireccion = c.getColumnIndex(KEY_DIRECCION);
        int itelefono = c.getColumnIndex(KEY_TELEFONO_CENTRO);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            centro.setId_centro(c.getInt(iid_centro));
            centro.setNombre(c.getString(inombre));
            centro.setLocLat(c.getString(ilat));
            centro.setLocLong(c.getString(ilon));
            centro.setId_responsable(c.getInt(iid_responsable));
            centro.setDireccion(c.getString(idireccion));
            centro.setTelefono(c.getString(itelefono));

            centro.setResponsable(getUser(centro.getId_responsable()));
        }

        return centro;
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

    public Long guardarUsuario(String nombre, String apellidos, String email, String pass, boolean is_admin) {
					
        long codigoInsert = 0;
        if (getUserbyMail(email) == false) {

            this.open();

            try {
                ContentValues cv = new ContentValues();
                cv.put(KEY_NOMBRE, nombre);
                cv.put(KEY_APELLIDOS, apellidos);
                cv.put(KEY_EMAIL, email);
                cv.put(KEY_PASS, pass);
                cv.put(KEY_ISADMIN, is_admin);

                codigoInsert = this.ourDatabase.insert(DATABASE_TABLE_USUARIOS, null, cv);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.close();
            }
        }
        return codigoInsert;

    }

    public void insertar(String tabla,ContentValues cv){
        try {
            this.open();
            this.ourDatabase.beginTransaction();
            this.ourDatabase.insert(tabla, null, cv);
            this.ourDatabase.setTransactionSuccessful();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.ourDatabase.endTransaction();
            this.close();
        }
    }
    public void actualizar(String tabla,ContentValues cv,String selection,String[] selectionArgs){
        try {
            this.open();
            this.ourDatabase.beginTransaction();
            this.ourDatabase.update(tabla, cv,selection,selectionArgs);
            this.ourDatabase.setTransactionSuccessful();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.ourDatabase.endTransaction();
            this.close();
        }
    }


    public Long editarUsuario(int idUsuario, String nombre, String apellidos, String email, String telefono, int id_centro) {
        this.open();
        this.ourDatabase.beginTransaction();
        long codigoInsert=0;

        try {
            ContentValues cv = new ContentValues();
            cv.put(KEY_NOMBRE, nombre);
            cv.put(KEY_APELLIDOS, apellidos);
            cv.put(KEY_EMAIL, email);
            cv.put(KEY_TELEFONO, telefono);
            cv.put(KEY_IDCENTRO, id_centro);

            String selection = KEY_ID_USUARIO + " = ?";
            String[] selectionArgs = new String[] { String.valueOf(idUsuario) };
            codigoInsert = this.ourDatabase.update(DATABASE_TABLE_USUARIOS, cv,selection,selectionArgs);
            this.ourDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.ourDatabase.endTransaction();
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

    public long cantidadRegistros(String tabla){

        this.open();
        long cont = DatabaseUtils.queryNumEntries(this.ourDatabase, tabla );
        this.close();

        return cont;
    }


    public  ArrayList<ListRanking> getRanking() {
        this.open();
        String[] columnas = new String[] {KEY_NOMBRE, KEY_PUNTOS};
        Cursor c = this.ourDatabase.query(DATABASE_VIEW_RANKING, columnas,null,null,null,null,null,null);

        ArrayList<ListRanking> resultado = new ArrayList<ListRanking>();

        int inombre = c.getColumnIndex(KEY_NOMBRE);
        int ipuntos = c.getColumnIndex(KEY_PUNTOS);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            String nombre = c.getString(inombre);
            String puntos = c.getString(ipuntos);

            //Usuarios usuario = new Usuarios(id_usuario, ipuntos);
            resultado.add(new ListRanking(nombre, puntos,""));
        }
        c.close();
        this.close();
        return resultado;
    }


}

