package com.tesseractmx.tesseract.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLIteHelper(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "app_database.db"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(
            "CREATE TABLE CLIENTE (id INTEGER PRIMARY KEY AUTOINCREMENT,NOMBRE TEXT,APELLIDO_MATERNO " +
                    " VARCHAR, APELLIDO_PATERNO VARCHAR, NACIMIENTO DATE, EMAIL TEXT,  TELEFONO VARCHAR,  SEXO CHAR, SALDO CURRENCY," +
                    "CONTRASENA_BANCA VARCHAR)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS CLIENTE")
        onCreate(db)
    }

    fun anadirDato (nombre : String, apellidoM : String, apellidoP: String, nacimiento:String, email:String, telefono:String,
    sexo:String, saldo:String, contrasena:String){
        val datos = ContentValues()
        datos.put("NOMBRE", nombre)
        datos.put("APELLIDO_MATERNO", apellidoM)
        datos.put("APELLIDO_PATERNO", apellidoP)
        datos.put("NACIMIENTO", nacimiento)
        datos.put("EMAIL", email)
        datos.put("TELEFONO", telefono)
        datos.put("SEXO", sexo)
        datos.put("SALDO", saldo)
        datos.put("CONTRASENA_BANCA", contrasena)

        val db = this.writableDatabase
        db.insert("CLIENTE", null, datos)
        db.close()
    }

    @SuppressLint("Range")
    fun revisarTabla(){
        val db = this.writableDatabase
        val query = "SELECT * FROM CLIENTE"
        val result = db.rawQuery(query, null)
        while (result.moveToNext()) {
            val columna1 = result.getString(result.getColumnIndex("NOMBRE"))
            val columna2 = result.getInt(result.getColumnIndex("APELLIDO_MATERNO"))
            val columna3 = result.getString(result.getColumnIndex("APELLIDO_PATERNO"))
            val columna4 = result.getInt(result.getColumnIndex("APELLIDO_MATERNO"))
            val columna5 = result.getString(result.getColumnIndex("NACIMIENTO"))
            val columna6 = result.getInt(result.getColumnIndex("EMAIL"))
            val columna7 = result.getString(result.getColumnIndex("TELEFONO"))
            val columna8 = result.getInt(result.getColumnIndex("SEXO"))
            val columna9 = result.getString(result.getColumnIndex("SALDO"))
            val columna10 = result.getInt(result.getColumnIndex("CONTRASENA_BANCA"))
            Log.d("App", "$columna1 - $columna2 $columna3 - $columna4 $columna5 - $columna6" +
                    "$columna7 - $columna8 $columna9 - $columna10")
        }
    }
}
