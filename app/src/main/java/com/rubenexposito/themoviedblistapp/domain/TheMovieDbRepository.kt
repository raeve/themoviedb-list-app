package com.rubenexposito.themoviedblistapp.domain

import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import io.reactivex.Single

interface TheMovieDbRepository {
    fun getPopularTvShows(language: String = "en-US", page: Int = 1): Single<List<TvShow>>
}