package com.rubenexposito.themoviedblistapp

import android.app.Activity
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailActivity

interface Navigator {
    fun showDetail(show: TvShow)
}

class NavigatorImpl(private val activity: Activity) : Navigator {
    override fun showDetail(show: TvShow) = activity.startActivity(ShowDetailActivity.getIntent(activity, show))
}