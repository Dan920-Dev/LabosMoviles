package com.jder00138218.laboratorio05.repositories

import com.jder00138218.laboratorio05.data.model.MovieModel


class MovieRepository(private val movies: MutableList<MovieModel> ) {
    fun getMovies() = movies
    fun addMovies(movie: MovieModel) = movies.add(movie)
}