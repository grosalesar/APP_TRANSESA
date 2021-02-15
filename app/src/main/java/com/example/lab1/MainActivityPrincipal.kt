package com.example.lab1

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.util.Log
import android.view.View

class MainActivityPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main_principal)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.irmapa -> {
                Log.i("===", "Click de Inicio!")
                val intent=Intent(applicationContext,Estaciones::class.java)
                startActivity(intent)
                return true
            }

            R.id.ir -> {
                Log.i("===", "Click de Inicio!")
                val intent=Intent(applicationContext,MenuSecundario::class.java)
                startActivity(intent)
                return true
            }
            R.id.camion -> {
                Log.i("===", "Click de Inicio!")
                val intent=Intent(applicationContext,MainActivityRegistrarVehiculo::class.java)
                startActivity(intent)
                return true
            }
            R.id.conductor -> {
                Log.i("===", "Click de Productos!")
                val intent= Intent(applicationContext,MainActivityRegistrarCond::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.secundario, menu)
        return super.onCreateOptionsMenu(menu)
    }




    fun btn1(view: View){
        //finish()
        val intent = Intent(this, MainActivityAbastecimiento::class.java)
        startActivity(intent)
    }
    fun btn2(view: View){
        //finish()
        val intent = Intent(this, MainActivityTiempos::class.java)
        startActivity(intent)
    }
    fun btn3(view: View){
        //finish()
        val intent = Intent(this, MainActivityActAbast::class.java)
        startActivity(intent)
    }
    fun btn4(view: View){
        //finish()
        val intent = Intent(this, PeliculasActivity::class.java)
        startActivity(intent)
    }

}