package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivityConsultaTiempos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_consulta_tiempos)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.principal, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_1 -> {
                Log.i("===", "Click de Inicio!")
                val intent= Intent(applicationContext,PeliculasActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_2 -> {
                Log.i("===", "Click de Productos!")
                return true
            }
            R.id.menu_3 -> {
                Log.i("===", "Click de Servicios!")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}