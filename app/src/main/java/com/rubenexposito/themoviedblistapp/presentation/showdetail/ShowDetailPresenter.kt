package com.rubenexposito.themoviedblistapp.presentation.showdetail

import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.domain.model.TvShow

class ShowDetailPresenter(private val view: ShowDetailContract.View, private val navigator: Navigator) : ShowDetailContract.Presenter {


    override fun bindIntent(tvShow: TvShow) {
        view.displayShow(tvShow)
    }
}