package com.rubenexposito.themoviedblistapp.presentation.showdetail

import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.common.BasePresenter
import com.rubenexposito.themoviedblistapp.presentation.common.BaseView
import com.rubenexposito.themoviedblistapp.presentation.common.ShowListener

interface ShowDetailContract {

    interface View : BaseView {
        fun displayShow(tvShow: TvShow)
    }

    interface Presenter : BasePresenter, ShowListener {
        fun bindIntent(tvShow: TvShow)
    }
}