package com.rubenexposito.themoviedblistapp.presentation.showlist

import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.domain.interactor.BaseUseCase
import com.rubenexposito.themoviedblistapp.domain.interactor.GetPopularTvShowsUseCase
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import java.util.*

class ShowListPresenter(
        private val view: ShowListContract.View,
        private val useCase: GetPopularTvShowsUseCase,
        private val navigator: Navigator
) : ShowListContract.Presenter {

    private var page = 1

    override fun onCreate() {
        requestData(true)
    }

    override fun onPause() {
        useCase.clear()
    }

    override fun requestData(reset: Boolean) {
        if (reset) page = 1

        view.showLoading()
        useCase.execute(
            object : BaseUseCase.Callback<List<TvShow>> {
                override fun onCompleted(result: List<TvShow>) {
                    if (reset) {
                        view.showTvShows(result)
                    } else {
                        view.addTvShows(result)
                    }

                    page++
                    view.hideLoading()
                }

                override fun onError(error: Throwable) {
                    view.showError(R.string.error_could_not_retrieve_data)
                    view.hideLoading()
                }
            },
            mapOf(
                GetPopularTvShowsUseCase.PARAM_LANGUAGE to Locale.getDefault().language,
                GetPopularTvShowsUseCase.PARAM_PAGE to page
            )
        )
    }

}