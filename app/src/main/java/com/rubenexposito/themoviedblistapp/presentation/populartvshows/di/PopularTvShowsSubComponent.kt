package com.rubenexposito.themoviedblistapp.presentation.populartvshows.di

import com.rubenexposito.themoviedblistapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.di.ActivityModule
import com.rubenexposito.themoviedblistapp.presentation.populartvshows.PopularTvShowsActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerActivity
@Subcomponent(modules = [ActivityModule::class, PopularTvShowsModule::class])
interface PopularTvShowsSubComponent : AndroidInjector<PopularTvShowsActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<PopularTvShowsActivity>()
}