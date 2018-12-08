package com.rubenexposito.themoviedblistapp.presentation.movielist

import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.domain.GetMovieListUseCase

class MovieListPresenter(
    private val view: MovieListContract.View,
    private val useCase: GetMovieListUseCase,
    private val navigator: Navigator
) : MovieListContract.Presenter {

    override fun onCreate() {
        //TODO Create interactor and retrieve data
    }
}