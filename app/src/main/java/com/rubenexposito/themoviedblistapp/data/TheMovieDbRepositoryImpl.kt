package com.rubenexposito.themoviedblistapp.data

import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.model.Movie
import io.reactivex.Single

class TheMovieDbRepositoryImpl : TheMovieDbRepository {
    override fun getMovies(): Single<List<Movie>> = Single.just(emptyList())
}