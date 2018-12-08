package com.rubenexposito.themoviedblistapp.presentation.movielist.di

import com.rubenexposito.contactsmarvelapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.di.ActivityModule
import com.rubenexposito.themoviedblistapp.presentation.movielist.MovieListActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerActivity
@Subcomponent(modules = [ActivityModule::class, MovieListModule::class])
interface MovieListSubComponent : AndroidInjector<MovieListActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieListActivity>()
}