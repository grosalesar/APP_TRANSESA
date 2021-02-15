package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivityRegistrarVehiculo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registrar_vehiculo)


        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages4)
        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivityRegistrarVehiculo,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }




        // access the items of the list
        val languages5 = resources.getStringArray(R.array.Languages5)
        // access the spinner
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        if (spinner2 != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages5)
            spinner2.adapter = adapter
            spinner2.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivityRegistrarVehiculo,
                        getString(R.string.selected_item) + " " +
                                "" + languages5[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }


    }

    fun btnvehiculo(view: View){
        val placa = findViewById<EditText>(R.id.placa)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val estadov = "ACTIVO"
        val dao = GeneroMusicalDAO(baseContext)
        try {
            val indice = dao.insertarv(placa.text.toString(), spinner.selectedItem.toString(), spinner2.selectedItem.toString(), estadov.toString())
            if (indice > 0) {
                placa.setText("")

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