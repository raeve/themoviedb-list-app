package com.rubenexposito.themoviedblistapp.presentation.movielist.di

import android.app.Activity
import com.rubenexposito.contactsmarvelapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.presentation.movielist.MovieListActivity
import com.rubenexposito.themoviedblistapp.presentation.movielist.MovieListContract
import com.rubenexposito.themoviedblistapp.presentation.movielist.MovieListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MovieListModule {

    @Binds
    @PerActivity
    internal abstract fun provideView(activity: MovieListActivity): MovieListContract.View

    @Binds
    @PerActivity
    internal abstract fun provideActivity(activity: MovieListActivity): Activity

    @Module
    companion object {

        @Provides
        @PerActivity
        @JvmStatic
        fun providePresenter(view: MovieListContract.View, navigator: Navigator): MovieListContract.Presenter =
            MovieListPresenter(view, navigator)
    }
}