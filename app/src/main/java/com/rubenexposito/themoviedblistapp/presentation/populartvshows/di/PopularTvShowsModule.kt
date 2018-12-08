package com.rubenexposito.themoviedblistapp.presentation.populartvshows.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.interactor.GetPopularTvShowsUseCase
import com.rubenexposito.themoviedblistapp.presentation.populartvshows.PopularTvShowsActivity
import com.rubenexposito.themoviedblistapp.presentation.populartvshows.PopularTvShowsContract
import com.rubenexposito.themoviedblistapp.presentation.populartvshows.PopularTvShowsPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

@Module
abstract class PopularTvShowsModule {

    @Binds
    @PerActivity
    internal abstract fun provideView(activity: PopularTvShowsActivity): PopularTvShowsContract.View

    @Binds
    @PerActivity
    internal abstract fun provideActivity(activity: PopularTvShowsActivity): Activity

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
            view: PopularTvShowsContract.View,
            useCase: GetPopularTvShowsUseCase,
            navigator: Navigator
        ): PopularTvShowsContract.Presenter = PopularTvShowsPresenter(view, useCase, navigator)
    }
}