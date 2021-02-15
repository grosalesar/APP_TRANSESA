package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PeliculasActivity : AppCompatActivity() {

    private val peliculaList: ArrayList<Pelicula> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: PeliculasAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)
        recyclerView = findViewById(R.id.recycler_view)
        mAdapter = PeliculasAdapter(peliculaList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = mAdapter
        preparePeliculaData()

    }

    private fun preparePeliculaData() {
        var pelicula = Pelicula(" Caycho Tarrillo Carlos", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "AYZ876")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Tomred Felipe Francisco", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "AZA865")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Quiroz Vendezu Alex", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "AYZ654")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Marquez Alies Felipe", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "AWS654")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Poma Sucaray Francisco", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "F0F988")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Casazola Beramendi Alexander", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "F8F765")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Guerrero Cardozo Alberto", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "F6F432")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Tarrillo Escorza Edinson", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "F7T007")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Conroy Guire Giuliano", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "B9F876")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Ardiles Gonzales Luis", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "X1X564")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Neyra Rivas Bayron", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "FCE123")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Velasquez Bendezu Villy", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01n", "XCF543")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Cipriano Perez Pele", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01n", "FGR543")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Lopez Trujillo Carlos", "Hora INT: 12/1/2021 12:04 y Hora OUT: 12/1/2021 16:01", "F6G765")
        peliculaList.add(pelicula)

        mAdapter.notifyDataSetChanged()
    }

    fun btnsalir(view: View){
        //finish()
        val intent = Intent(this, MainActivityPrincipal::class.java)
        startActivity(intent)
    }


}