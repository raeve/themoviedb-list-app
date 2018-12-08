package com.rubenexposito.themoviedblistapp.di

import com.rubenexposito.themoviedblistapp.data.TheMovieDbRepositoryImpl
import com.rubenexposito.themoviedblistapp.data.dto.TheMovieDbMapper
import com.rubenexposito.themoviedblistapp.data.network.RetrofitAdapter
import com.rubenexposito.themoviedblistapp.data.network.TheMovieDbApi
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideTheMovieDbRepository(): TheMovieDbRepository =
        TheMovieDbRepositoryImpl(RetrofitAdapter.retrofit.create(TheMovieDbApi::class.java), TheMovieDbMapper())
}