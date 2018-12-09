package com.rubenexposito.themoviedblistapp.presentation.showdetail

import android.widget.ImageView
import android.widget.TextView
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.common.serverLanguage
import com.rubenexposito.themoviedblistapp.domain.interactor.BaseUseCase
import com.rubenexposito.themoviedblistapp.domain.interactor.GetSimilarTvShowsUseCase
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import java.util.*

class ShowDetailPresenter(
    private val view: ShowDetailContract.View,
    private val useCase: GetSimilarTvShowsUseCase,
    private val navigator: Navigator
) : ShowDetailContract.Presenter {
    private var page = 1

    override fun onPause() {
        useCase.clear()
    }

    override fun bindIntent(id: Int) {
        requestRecommended(id)
    }

    override fun onShowSelected(show: TvShow, imageView: ImageView) {
        navigator.showDetail(show, imageView)
    }

    private fun requestRecommended(id: Int) {
        useCase.execute(
            object : BaseUseCase.Callback<List<TvShow>> {
                override fun onCompleted(result: List<TvShow>) {
                    if (result.isNotEmpty()) {
                        view.displaySimilarShows(result)
                    } else {
                        view.displayEmptySimilarShows()
                    }
                }

                override fun onError(error: Throwable) {
                    view.displayEmptySimilarShows()
                }

            }, mapOf(
                GetSimilarTvShowsUseCase.PARAM_ID to id,
                GetSimilarTvShowsUseCase.PARAM_LANGUAGE to Locale.getDefault().serverLanguage(),
                GetSimilarTvShowsUseCase.PARAM_PAGE to page
            )
        )
    }
}