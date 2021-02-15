package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main_abastecimiento.*
import android.widget.Spinner
import android.widget.Toast
import java.util.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import java.text.SimpleDateFormat



class MainActivityAbastecimiento : AppCompatActivity() {

    lateinit var resultados : ArrayList<GeneroMusical>
    lateinit var listaResultados : ListView
    lateinit var spinner2:Spinner
    lateinit var spinner:Spinner
    lateinit var dao:GeneroMusicalDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_abastecimiento)
        etDate.setOnClickListener { showDatePickerDialog() }
        // Fecha y Hora
        val fecha = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        etDate.setText(fecha.format(Date()))
        // Listar Placa
        dao = GeneroMusicalDAO(baseContext)
        spinner = findViewById(R.id.spinner)
        val listaGeneros2 = dao.listarVehiculo()
        val miadapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaGeneros2);
        spinner.adapter = miadapter2
        // Listar Conductor
        dao = GeneroMusicalDAO(baseContext)
        spinner2 = findViewById(R.id.spinner2)
        val listaGeneros = dao.listar()
        val miadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaGeneros);
        spinner2.adapter = miadapter


//        val languages = resources.getStringArray(R.array.Languages)
//        val spinner = findViewById<Spinner>(R.id.spinner)
//        if (spinner != null) {
//            val adapter = ArrayAdapter(this,
//                    android.R.layout.simple_spinner_item, languages)
//            spinner.adapter = adapter
//            spinner.onItemSelectedListener = object :
 //                   AdapterView.OnItemSelectedListener {
 //               override fun onItemSelected(parent: AdapterView<*>,
 //                                           view: View, position: Int, id: Long) {
 //                   Toast.makeText(this@MainActivityAbastecimiento,
 //                           getString(R.string.selected_item) + " " +
 //                                   "" + languages[position], Toast.LENGTH_SHORT).show()
 //               }
 //               override fun onNothingSelected(parent: AdapterView<*>) {
 //               }
 //           }
 //       }


        // access the items of the list
   //     val languages2 = resources.getStringArray(R.array.Languages2)
        // access the spinner
   //     val spinner2 = findViewById<Spinner>(R.id.spinner2)
   //     if (spinner2 != null) {
   //         val adapter2 = ArrayAdapter(this,
   //                 android.R.layout.simple_spinner_item, languages2)
   //        spinner2.adapter = adapter2
   //         spinner2.onItemSelectedListener = object :
   //                 AdapterView.OnItemSelectedListener {
   //             override fun onItemSelected(parent: AdapterView<*>,
   //                                         view: View, position: Int, id: Long) {
   //                 Toast.makeText(this@MainActivityAbastecimiento,
   //                         getString(R.string.selected_item) + " " +
   //                                 "" + languages2[position], Toast.LENGTH_SHORT).show()
   //             }

   //             override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
   //             }
   //         }
   //     }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showDatePickerDialog() {
        val datePicker=DatePickerFragment{day,month,year -> onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        var x=month+1
        val fecha = SimpleDateFormat("$day/$x/$year hh:mm:ss")
        etDate.setText(fecha.format(Date()))
    }


    ////Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_1 -> {
                Log.i("===", "Click de Inicio!")
                val intent= Intent(applicationContext,MainActivityActAbast::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_2 -> {
                Log.i("===", "Click de Productos!")
                val intent= Intent(applicationContext,MainActivityActTiempos::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_3 -> {
                Log.i("===", "Click de Servicios!")
                val intent= Intent(applicationContext,MainActivityPrincipal::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun btnabastecimiento(view: View){

        val fecha = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val fecha_sistema = fecha.format(Date())

        val fechahoraabaste = findViewById<EditText>(R.id.etDate)
        val cantgalones = findViewById<EditText>(R.id.cantgalones)
        val kilometraje = findViewById<EditText>(R.id.kilometraje)
        val spinner = findViewById<Spinner>(R.id.spinner) // placa
        val spinner2 = findViewById<Spinner>(R.id.spinner2) // conductor
        val estadoc = "ACTIVO"

        val dao = GeneroMusicalDAO(baseContext)
        try {
            val indice = dao.insertara(fecha_sistema.toString(),fechahoraabaste.text.toString(), cantgalones.text.toString(), kilometraje.text.toString(), estadoc.toString(),spinner.selectedItem.toString(), spinner2.selectedItem.toString())

            if (indice > 0) {

                cantgalones.setText("")

                Toast.makeText(baseContext, "Se insertó correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(baseContext, "Ocurrió un error al intentar insertar", Toast.LENGTH_SHORT).show()
            }
        } catch (e: DAOException) {
            Log.i(Tools.LOGTAG, "====> " + e.message)
        }
        //finish()
        val intent = Intent(this, MainActivityPrincipal::class.java)
        startActivity(intent)
    }

}