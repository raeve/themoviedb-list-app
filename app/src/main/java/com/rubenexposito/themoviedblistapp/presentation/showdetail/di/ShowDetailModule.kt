package com.rubenexposito.themoviedblistapp.presentation.showdetail.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.interactor.GetSimilarTvShowsUseCase
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailActivity
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailContract
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

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
        fun provideGetSimilarTvShowsUseCase(theMovieDbRepository: TheMovieDbRepository,
                                            @Named("observeOn") observeOn: Scheduler,
                                            @Named("subscribeOn") subscribeOn: Scheduler) =
                GetSimilarTvShowsUseCase(theMovieDbRepository, observeOn, subscribeOn)

        @Provides
        @PerActivity
        @JvmStatic
        fun providePresenter(view: ShowDetailContract.View, useCase: GetSimilarTvShowsUseCase,navigator: Navigator): ShowDetailContract.Presenter =
            ShowDetailPresenter(view, useCase, navigator)
    }

}