package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivityRegistrarCond : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registrar_cond)

        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages6)
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
                    Toast.makeText(this@MainActivityRegistrarCond,
                            getString(R.string.selected_item) + " " +
                                    "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    fun btnconductor(view: View) {
        val dni = findViewById<EditText>(R.id.dni)
        val nrolicencia = findViewById<EditText>(R.id.nrolicencia)
        val apellidosnombre = findViewById<EditText>(R.id.apellidosnombre)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val estadoc = "ACTIVO"
        val dao = GeneroMusicalDAO(baseContext)
        try {
            val indice = dao.insertar(dni.text.toString(), apellidosnombre.text.toString(),nrolicencia.text.toString(),spinner.selectedItem.toString(), estadoc.toString())
            if (indice > 0) {
                dni.setText("")
                nrolicencia.setText("")
                apellidosnombre.setText("")

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

