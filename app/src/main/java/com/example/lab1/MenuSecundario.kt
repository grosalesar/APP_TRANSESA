package com.example.lab1

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.jar.Manifest

class MenuSecundario : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_secundario)
       //FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.ButtonTest4);


    }
    fun btn1(view: View){
        //finish()
        val intent = Intent(this, RegistrarDocumentos::class.java)
        startActivity(intent)
    }
    fun btn2(view: View){
        //finish()
        val intent = Intent(this, ConsultarDocumento::class.java)
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

    fun btnoperaciones(view: View){
        //finish()
       val intent = Intent(this, Agenda::class.java)
       startActivity(intent)

    }

    fun btncamara(view: View){
        //finish()
        val intent = Intent(this, Imagen::class.java)
        startActivity(intent)
    }



}