package com.rubenexposito.themoviedblistapp.presentation.populartvshows

import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.domain.interactor.GetPopularTvShowsUseCase

class PopularTvShowsPresenter(
    private val view: PopularTvShowsContract.View,
    private val useCase: GetPopularTvShowsUseCase,
    private val navigator: Navigator
) : PopularTvShowsContract.Presenter {

    override fun onCreate() {
        //TODO Create interactor and retrieve data
    }
}