package com.example.lab1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class GeneroMusicalDAO (myContext: Context) {

    private var dbHelper: DbHelper = DbHelper(myContext)

    fun insertar(dni: String, apellidosnombre: String, nrolicencia: String, clasecategorialicencia: String, estadoc: String): Long {
        Log.i(Tools.LOGTAG, "Ingresó al método insertar()")
        val indice: Long
        val values = ContentValues().apply {
            put("dni", dni)
            put("apellidosnombre", apellidosnombre)
            put("nrolicencia", nrolicencia)
            put("clasecategorialicencia", clasecategorialicencia)
            put("estadoc", estadoc)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert(Tools.MITABLA,null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }


    fun insertarv(placa: String, marca: String, modelo: String, estadov: String): Long {
        Log.i(Tools.LOGTAG, "Ingresó al método insertar()")
        val indice: Long
        val values = ContentValues().apply {
            put("placa", placa)
            put("marca", marca)
            put("modelo", modelo)
            put("estadov", estadov)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert(Tools.MITABLAV,null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }

    fun insertara(fecreg: String, fechahoraabaste: String, cantgalones: String, kilometraje: String, estado: String, vehiculo_placa: String, conductor_dni: String): Long {
        Log.i(Tools.LOGTAG, "Ingresó al método insertar()")

        //val fecha = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        //val fecha_sistema = fecha.format(Date())

        val indice: Long
        val values = ContentValues().apply {
            put("fecreg", fecreg)
            put("fechahoraabaste", fechahoraabaste)
            put("cantgalones", cantgalones)
            put("kilometraje", kilometraje)
            put("estado", estado)
            put("vehiculo_placa", vehiculo_placa)
            put("conductor_dni", conductor_dni)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert(Tools.MITABLAA,null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }

    fun insertart(fecreg: String, fechahoraingreso: String, fechahorasalida: String, estado: String, vehiculo_placa: String, conductor_dni: String, cda: String): Long {
        Log.i(Tools.LOGTAG, "Ingresó al método insertar()")

        val indice: Long
        val values = ContentValues().apply {
            put("fecreg", fecreg)
            put("fechahoraingreso", fechahoraingreso)
            put("fechahorasalida", fechahorasalida)
            put("estado", estado)
            put("vehiculo_placa", vehiculo_placa)
            put("conductor_dni", conductor_dni)
            put("cda", cda)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert(Tools.MITABLAT,null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al insertar: " + e.message)
        } finally {
            db.close()
        }
    }



    // Listado de Conductor(s)
    fun listar(): ArrayList<String> {
        Log.i(Tools.LOGTAG, "Ingresó al método listar()")
        val db = dbHelper.readableDatabase
        val lista = ArrayList<String>()
        try {
            val c: Cursor = db.rawQuery(
                    "select idconductor, dni, apellidosnombre from " + Tools.MITABLA ,
                    null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val idconductor: Int = c.getInt(c.getColumnIndex("idconductor"))
                    val dni: String = c.getString(c.getColumnIndex("dni"))
                    val apellidosnombre: String = c.getString(c.getColumnIndex("apellidosnombre"))
                    lista.add("$apellidosnombre") //$idconductor - $dni -
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al listar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }


    // Listado de Vehiculo(s)
    fun listarVehiculo(): ArrayList<String> {
        Log.i(Tools.LOGTAG, "Ingresó al método listar()")
        val db = dbHelper.readableDatabase
        val lista = ArrayList<String>()
        try {
            val c: Cursor = db.rawQuery(
                    "select idvehiculo, placa from " + Tools.MITABLAV ,
                    null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val idvehiculo: Int = c.getInt(c.getColumnIndex("idvehiculo"))
                    val placa: String = c.getString(c.getColumnIndex("placa"))
                    lista.add("$placa")
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al listar: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }




    fun obtener(): GeneroMusical {
        Log.i(Tools.LOGTAG, "Ingresó al método obtener()")
        val db = dbHelper.readableDatabase
        val modelo = GeneroMusical()
        try {
            val c: Cursor = db.rawQuery("select id, titulo, descripcion from " + Tools.MITABLA, null)
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val titulo: String = c.getString(c.getColumnIndex("titulo"))
                    val descripcion: String = c.getString(c.getColumnIndex("descripcion"))
                    modelo.id = id
                    modelo.titulo = titulo
                    modelo.descripcion = descripcion
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return modelo
    }

    fun buscar(criterio: String): ArrayList<GeneroMusical> {
        Log.i(Tools.LOGTAG, "Ingresó al método buscar()")
        val db = dbHelper.readableDatabase
        val lista = ArrayList<GeneroMusical>()
        try {
            val c: Cursor = db.rawQuery(
                    "select id, titulo, descripcion from " + Tools.MITABLA + " where titulo like '%$criterio%' or descripcion like '%$criterio%'",
                    null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id: Int = c.getInt(c.getColumnIndex("id"))
                    val titulo: String = c.getString(c.getColumnIndex("titulo"))
                    val descripcion: String = c.getString(c.getColumnIndex("descripcion"))
                    val modelo = GeneroMusical()
                    modelo.id = id
                    modelo.titulo = titulo
                    modelo.descripcion = descripcion
                    lista.add(modelo)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun eliminar(id: Int) {
        Log.i(Tools.LOGTAG, "Ingresó al método eliminar()")
        val db = dbHelper.writableDatabase
        try {
            val args = arrayOf(id.toString())
            db.execSQL("DELETE FROM " + Tools.MITABLA + " WHERE id=?", args)
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al eliminar: " + e.message)
        } finally {
            db.close()
        }
    }

    fun eliminarTodos() {
        Log.i(Tools.LOGTAG, "Ingresó al método eliminarTodos()")
        val db = dbHelper.writableDatabase
        try {
            db.execSQL("DELETE FROM " + Tools.MITABLA)
        } catch (e: Exception) {
            throw DAOException("GeneroMusicalDAO: Error al eliminar todos: " + e.message)
        } finally {
            db.close()
        }
    }

}


