package com.example.lab1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Factory es null porque se va a usar el SQLiteCursor
class DbHelper(myContext: Context): SQLiteOpenHelper(myContext,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "estrategico6.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE IF NOT EXISTS conductor (idconductor INTEGER PRIMARY KEY AUTOINCREMENT, dni TEXT NOT NULL, apellidosnombre TEXT NOT NULL, nrolicencia TEXT NOT NULL, clasecategorialicencia TEXT NOT NULL, estadoc TEXT NOT NULL)"
        db.execSQL(sql)

        val sql2 = "CREATE TABLE IF NOT EXISTS vehiculo (idvehiculo INTEGER PRIMARY KEY AUTOINCREMENT, placa TEXT NOT NULL, marca TEXT NOT NULL, modelo TEXT NOT NULL, estadov TEXT NOT NULL)"
        db.execSQL(sql2)

        val sql3 = "CREATE TABLE IF NOT EXISTS abastecimiento (nroabaste INTEGER PRIMARY KEY AUTOINCREMENT, fecreg TEXT NOT NULL, fechahoraabaste TEXT NOT NULL, cantgalones INTEGER NOT NULL, kilometraje INTEGER NOT NULL,estado TEXT NOT NULL, vehiculo_placa TEXT NOT NULL,conductor_dni TEXT NOT NULL)"
        db.execSQL(sql3)


        val sql4 = "CREATE TABLE IF NOT EXISTS tiempo (nrotiempo INTEGER PRIMARY KEY AUTOINCREMENT, fecreg TEXT NOT NULL, fechahoraingreso TEXT NOT NULL, fechahorasalida TEXT NOT NULL,estado TEXT NOT NULL, vehiculo_placa TEXT NOT NULL,conductor_dni TEXT NOT NULL,cda TEXT NOT NULL)"
        db.execSQL(sql4)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS conductor")
        onCreate(db)
        db.execSQL("DROP TABLE IF EXISTS vehiculo")
        onCreate(db)
        db.execSQL("DROP TABLE IF EXISTS abastecimiento")
        onCreate(db)
        db.execSQL("DROP TABLE IF EXISTS tiempos")
        onCreate(db)
    }
}

