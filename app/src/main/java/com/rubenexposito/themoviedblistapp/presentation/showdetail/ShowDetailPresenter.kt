package com.rubenexposito.themoviedblistapp.presentation.showdetail

import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.serverLanguage
import com.rubenexposito.themoviedblistapp.domain.interactor.BaseUseCase
import com.rubenexposito.themoviedblistapp.domain.interactor.GetSimilarTvShowsUseCase
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import java.util.*

class ShowDetailPresenter(private val view: ShowDetailContract.View, private val useCase: GetSimilarTvShowsUseCase, private val navigator: Navigator) : ShowDetailContract.Presenter {
    private var page = 1

    override fun onPause() {
        useCase.clear()
    }

    override fun bindIntent(tvShow: TvShow) {
        view.displayShow(tvShow)
        requestRecommended(tvShow.id)
    }

    override fun onShowSelected(show: TvShow) {
        navigator.showDetail(show)
    }

    private fun requestRecommended(id: Int) {
        view.showLoading()
        useCase.execute(object : BaseUseCase.Callback<List<TvShow>> {
            override fun onCompleted(result: List<TvShow>) {
                view.displaySimilarShows(result)
                view.hideLoading()
            }

            override fun onError(error: Throwable) {
                view.showError(R.string.error_could_not_retrieve_data)
                view.hideLoading()
            }

        }, mapOf(GetSimilarTvShowsUseCase.PARAM_ID to id,
                GetSimilarTvShowsUseCase.PARAM_LANGUAGE to Locale.getDefault().serverLanguage(),
                GetSimilarTvShowsUseCase.PARAM_PAGE to page))
    }
}