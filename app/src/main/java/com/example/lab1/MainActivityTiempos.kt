package com.example.lab1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_tiempos.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivityTiempos : AppCompatActivity(), DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
    var day=0
    var month=0
    var year=0
    var hour=0
    var minute=0

    var savedDay=0
    var savedMonth=0
    var savedYear=0
    var savedHour=0
    var savedMinute=0



    lateinit var resultados : ArrayList<GeneroMusical>
    lateinit var listaResultados : ListView
    lateinit var spinner:Spinner
    lateinit var spinner2:Spinner
    lateinit var spinner3:Spinner
    lateinit var dao:GeneroMusicalDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tiempos)

        btndesde.setTextColor(Color.parseColor("#FDFEFE"));
        pickDate()

        // Fecha y Hora
        val fecha = SimpleDateFormat("dd/M/yyyy hh:mm")
        txtfechasalida.setText(fecha.format(Date()))


        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages3)
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
                    Toast.makeText(this@MainActivityTiempos,
                            getString(R.string.selected_item) + " " +
                                    "" + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }




        // Listar Conductor
        dao = GeneroMusicalDAO(baseContext)
        spinner2 = findViewById(R.id.spinner2)
        val listaGeneros = dao.listarVehiculo()
        val miadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaGeneros);
        spinner2.adapter = miadapter

        // Listar Conductor
        dao = GeneroMusicalDAO(baseContext)
        spinner3 = findViewById(R.id.spinner3)
        val listaGeneros3 = dao.listar()
        val miadapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaGeneros3);
        spinner3.adapter = miadapter3


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.principal, menu)
        return super.onCreateOptionsMenu(menu)
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



    fun btntiempos(view: View){


        val fecha = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val fecreg = fecha.format(Date())

        val txtfechaingreso = findViewById<EditText>(R.id.txtfechaingreso)
        val txtfechasalida = findViewById<EditText>(R.id.txtfechasalida)
        val estado3 = "ACTIVO"
        val spinner = findViewById<Spinner>(R.id.spinner) // placa
        val spinner2 = findViewById<Spinner>(R.id.spinner2) // conductor
        val spinner3 = findViewById<Spinner>(R.id.spinner3) // cda

        val dao = GeneroMusicalDAO(baseContext)
        try {
            val indice = dao.insertart(fecreg.toString(),txtfechaingreso.text.toString(), txtfechasalida.text.toString(), estado3.toString(),spinner2.selectedItem.toString(),spinner3.selectedItem.toString(),spinner.selectedItem.toString())

            if (indice > 0) {

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


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay=dayOfMonth
        savedMonth=month
        savedYear=year
        getDateTimeCalendar()
        TimePickerDialog(this,this,hour, minute,true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour=hourOfDay
        savedMinute=minute
        var h=savedMonth+1
        txtfechaingreso.setText("$savedDay/$h/$savedYear $savedHour:$savedMinute")

    }

    private fun getDateTimeCalendar(){
        val cal: Calendar=Calendar.getInstance()
        day=cal.get(Calendar.DAY_OF_MONTH)
        month=cal.get(Calendar.MONTH)
        year=cal.get(Calendar.YEAR)
        hour=cal.get(Calendar.HOUR)
        minute=cal.get(Calendar.MINUTE)
    }

    private fun pickDate(){
        btndesde.setOnClickListener{
            getDateTimeCalendar()
            DatePickerDialog(this,this,year,month,day ).show()
        }



    }


}