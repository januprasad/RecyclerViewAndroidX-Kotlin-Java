package com.jk.recyclervew_kotlin

class MovieRepository (private val source: MovieSource) {

    fun initRepo() : List<Movie> = source.buildSource()

}