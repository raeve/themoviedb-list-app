package com.rubenexposito.themoviedblistapp.presentation.populartvshows

import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.common.BaseView

interface PopularTvShowsContract {
    interface View : BaseView {
        fun showTvShows(tvShows: List<TvShow>)
        fun addTvShows(tvShows: List<TvShow>)
    }

    interface Presenter {
        fun onCreate()
        fun requestData(reset: Boolean)
        fun onPause()
    }
}