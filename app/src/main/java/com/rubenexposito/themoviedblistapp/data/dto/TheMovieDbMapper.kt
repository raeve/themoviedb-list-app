package com.rubenexposito.themoviedblistapp.data.dto

import com.rubenexposito.themoviedblistapp.BaseConfig
import com.rubenexposito.themoviedblistapp.domain.model.TvShow

class TheMovieDbMapper {

    fun map(results: List<TvShowDto>): List<TvShow> = results.map {
        TvShow(
                it.id,
                it.name,
                it.overview,
                if (!it.backdrop_path.isNullOrBlank()) imageBackdrop(it.backdrop_path) else imagePoster(it.poster_path),
                if (!it.poster_path.isNullOrBlank()) imagePoster(it.poster_path) else imageBackdrop(it.backdrop_path),
                it.vote_average
        )
    }


    private fun imagePoster(path: String?) = path?.let { BaseConfig.API_IMAGE_BASE_URL + BaseConfig.API_IMAGE_POSTER_SIZE + path }
            ?: ""

    private fun imageBackdrop(path: String?) = path?.let { BaseConfig.API_IMAGE_BASE_URL + BaseConfig.API_IMAGE_BACKDROP_SIZE + path }
            ?: ""
}