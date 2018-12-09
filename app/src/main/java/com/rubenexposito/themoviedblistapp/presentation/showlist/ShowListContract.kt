package com.rubenexposito.themoviedblistapp.presentation.showlist

import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.common.BaseView
import com.rubenexposito.themoviedblistapp.presentation.common.ShowListener

interface ShowListContract {
    interface View : BaseView {
        fun showTvShows(tvShows: List<TvShow>)
        fun addTvShows(tvShows: List<TvShow>)
    }

    interface Presenter : ShowListener{
        fun onCreate()
        fun requestData(reset: Boolean)
        fun onPause()
    }
}