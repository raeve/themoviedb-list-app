package com.rubenexposito.themoviedblistapp

import android.app.Activity
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.rubenexposito.themoviedblistapp.common.landscape
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailActivity

interface Navigator {
    fun showDetail(show: TvShow, imageView: ImageView)
}

class NavigatorImpl(private val activity: Activity) : Navigator {
    override fun showDetail(show: TvShow, imageView: ImageView) {
        activity.startActivity(
            ShowDetailActivity.getIntent(activity, show), if (activity.landscape())
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity,
                    Pair.create(imageView, imageView.transitionName)
                ).toBundle() else null
        )
    }
}