package com.jder00138218.laboratorio05

import android.app.Application
import com.jder00138218.laboratorio05.data.movies
import com.jder00138218.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {

        MovieRepository(movies)
    }
}