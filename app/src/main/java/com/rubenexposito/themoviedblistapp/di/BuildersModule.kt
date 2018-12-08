package com.rubenexposito.themoviedblistapp.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.presentation.populartvshows.PopularTvShowsActivity
import com.rubenexposito.themoviedblistapp.presentation.populartvshows.di.PopularTvShowsSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(PopularTvShowsActivity::class)
    abstract fun bindContactsActivityInjectorFactory(builder: PopularTvShowsSubComponent.Builder): AndroidInjector.Factory<out Activity>
}