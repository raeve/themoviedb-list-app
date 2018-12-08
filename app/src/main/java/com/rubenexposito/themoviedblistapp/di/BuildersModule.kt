package com.rubenexposito.contactsmarvelapp.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.presentation.movielist.MovieListActivity
import com.rubenexposito.themoviedblistapp.presentation.movielist.di.MovieListSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(MovieListActivity::class)
    abstract fun bindContactsActivityInjectorFactory(builder: MovieListSubComponent.Builder): AndroidInjector.Factory<out Activity>
}