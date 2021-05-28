package com.jk.recyclervew_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MovieViewModel : ViewModel() {

    val moviesRepo = MovieRepository(LocalMovieSource())

    private val moviesLiveData: LiveData<List<Movie>> by lazy {
        val liveData = MutableLiveData<List<Movie>>()
        /**
         * async operation for fetching....the db
         */
        liveData.postValue(moviesRepo.initRepo())
        return@lazy liveData
    }

    fun movies(): LiveData<List<Movie>> = moviesLiveData
}