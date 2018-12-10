package com.rubenexposito.themoviedblistapp.presentation.showlist.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.interactor.GetPopularTvShowsUseCase
import com.rubenexposito.themoviedblistapp.presentation.showlist.ShowListActivity
import com.rubenexposito.themoviedblistapp.presentation.showlist.ShowListContract
import com.rubenexposito.themoviedblistapp.presentation.showlist.ShowListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

@Module
abstract class ShowListModule {

    @Binds
    @PerActivity
    internal abstract fun provideView(activity: ShowListActivity): ShowListContract.View

    @Binds
    @PerActivity
    internal abstract fun provideActivity(activity: ShowListActivity): Activity

    @Module
    companion object {

        @Provides
        @PerActivity
        @JvmStatic
        fun provideGetMovieListUseCase(
            theMovieDbRepository: TheMovieDbRepository,
            @Named("observeOn") observeOn: Scheduler,
            @Named("subscribeOn") subscribeOn: Scheduler
        ) = GetPopularTvShowsUseCase(theMovieDbRepository, observeOn, subscribeOn)

        @Provides
        @PerActivity
        @JvmStatic
        fun providePresenter(
                view: ShowListContract.View,
                useCase: GetPopularTvShowsUseCase,
                navigator: Navigator
        ): ShowListContract.Presenter = ShowListPresenter(view, useCase, navigator)
    }
}