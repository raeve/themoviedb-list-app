package com.rubenexposito.themoviedblistapp.di

import com.rubenexposito.themoviedblistapp.data.TheMovieDbRepositoryImpl
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideTheMovieDbRepository(): TheMovieDbRepository = TheMovieDbRepositoryImpl()
}