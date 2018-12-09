package com.rubenexposito.themoviedblistapp

import android.app.Activity
import com.rubenexposito.themoviedblistapp.domain.model.TvShow

interface Navigator {
    fun showDetail(show: TvShow)
}

class NavigatorImpl(private val activity: Activity) : Navigator {
    override fun showDetail(show: TvShow) {

    }
}