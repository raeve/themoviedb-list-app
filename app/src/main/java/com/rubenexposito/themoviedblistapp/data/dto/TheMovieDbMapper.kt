package com.rubenexposito.themoviedblistapp.data.dto

import com.rubenexposito.themoviedblistapp.BaseConfig
import com.rubenexposito.themoviedblistapp.domain.model.TvShow

class TheMovieDbMapper {

    fun map(results: List<TvShowDto>): List<TvShow> = results.map {
        TvShow(
            it.name,
            it.overview,
            imageBackdrop(it.backdrop_path),
            imagePoster(it.poster_path),
            it.vote_average
        )
    }


    private fun imagePoster(path: String) = BaseConfig.API_IMAGE_BASE_URL + BaseConfig.API_IMAGE_POSTER_SIZE + path

    private fun imageBackdrop(path: String) = BaseConfig.API_IMAGE_BASE_URL + BaseConfig.API_IMAGE_BACKDROP_SIZE + path
}