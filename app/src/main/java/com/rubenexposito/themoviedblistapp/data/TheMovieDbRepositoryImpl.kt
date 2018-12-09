package com.rubenexposito.themoviedblistapp.data

import com.rubenexposito.themoviedblistapp.BaseConfig
import com.rubenexposito.themoviedblistapp.data.dto.TheMovieDbMapper
import com.rubenexposito.themoviedblistapp.data.network.TheMovieDbApi
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import io.reactivex.Single

class TheMovieDbRepositoryImpl(private val theMovieDbApi: TheMovieDbApi, private val mapper: TheMovieDbMapper) :
        TheMovieDbRepository {

    override fun getPopularTvShows(language: String, page: Int): Single<List<TvShow>> =
            theMovieDbApi.getPopularTvShows(BaseConfig.API_KEY, language, page).map { mapper.map(it.results) }

    override fun getSimilarTvShows(id: Int, language: String, page: Int): Single<List<TvShow>> =
            theMovieDbApi.getSimilarTvShows(id, BaseConfig.API_KEY, language, page).map { mapper.map(it.results) }

}