package com.jk.recyclervew_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MoviesAdapter(private val moviesList: List<Movie>?) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var year: TextView = view.findViewById(R.id.year)
        var genre: TextView = view.findViewById(R.id.genre)

        init {
            genre = view.findViewById(R.id.genre)
            year = view.findViewById(R.id.year)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movies_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList?.get(position)
        holder.title.text = movie?.title
        holder.genre.text = movie?.genre
        holder.year.text = movie?.year
    }

    override fun getItemCount(): Int {
        if (moviesList != null) {
            return moviesList.size
        } else return 0
    }
}