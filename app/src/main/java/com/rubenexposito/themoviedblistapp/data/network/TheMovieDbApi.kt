package com.rubenexposito.themoviedblistapp.data.network

import com.rubenexposito.themoviedblistapp.data.dto.GetPopularTvShowsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApi {

    @GET("tv/popular")
    fun getPopularTvShows(
        @Query("api_key") api: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Single<GetPopularTvShowsResponse>
}