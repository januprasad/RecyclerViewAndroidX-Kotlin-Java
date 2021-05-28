package com.jk.recyclervew_kotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model: MovieViewModel by viewModels()
        model.movies().observe(this, { movies ->
            toUI(movies)
        })

    }

    private fun toUI(movies: List<Movie>?) {

        val recyclerView = findViewById<RecyclerView>(R.id.movies)
        val mAdapter = MoviesAdapter(movies)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

}