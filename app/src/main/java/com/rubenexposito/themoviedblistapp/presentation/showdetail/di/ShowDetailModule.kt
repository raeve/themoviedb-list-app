package com.rubenexposito.themoviedblistapp.presentation.showdetail.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailActivity
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailContract
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ShowDetailModule {

    @Binds
    @PerActivity
    internal abstract fun provideView(activity: ShowDetailActivity): ShowDetailContract.View

    @Binds
    @PerActivity
    internal abstract fun provideActivity(activity: ShowDetailActivity): Activity

    @Module
    companion object {

        @Provides
        @PerActivity
        @JvmStatic
        fun providePresenter(view: ShowDetailContract.View, navigator: Navigator): ShowDetailContract.Presenter =
            ShowDetailPresenter(view, navigator)
    }

}