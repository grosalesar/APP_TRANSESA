package com.example.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeliculasAdapter(private val peliculasList: List<Pelicula>): RecyclerView.Adapter<PeliculasAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder = MyViewHolder(layoutInflater.inflate(R.layout.pelicula_fila, parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pelicula = peliculasList[position]
        holder.titulo.setText(pelicula.titulo)
        holder.genero.setText(pelicula.genero)
        holder.anio.setText(pelicula.anio)

    }

    override fun getItemCount(): Int {
        return peliculasList.size
    }

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val titulo = view.findViewById<TextView>(R.id.titulo)
        val genero = view.findViewById<TextView>(R.id.genero)
        val anio = view.findViewById<TextView>(R.id.anio)

    }

}

