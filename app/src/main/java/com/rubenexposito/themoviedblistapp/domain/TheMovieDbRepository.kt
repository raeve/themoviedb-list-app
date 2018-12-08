package com.rubenexposito.themoviedblistapp.domain

import com.rubenexposito.themoviedblistapp.domain.model.Movie
import io.reactivex.Single

interface TheMovieDbRepository {
    fun getMovies() : Single<List<Movie>>
}