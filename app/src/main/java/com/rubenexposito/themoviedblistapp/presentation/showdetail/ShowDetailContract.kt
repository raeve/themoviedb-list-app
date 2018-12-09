package com.rubenexposito.themoviedblistapp.presentation.showdetail

import com.rubenexposito.themoviedblistapp.domain.model.TvShow

interface ShowDetailContract {

    interface View {
        fun displayShow(tvShow: TvShow)
    }

    interface Presenter {
        fun bindIntent(tvShow: TvShow)
    }
}