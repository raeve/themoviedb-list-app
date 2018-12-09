package com.rubenexposito.themoviedblistapp.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailActivity
import com.rubenexposito.themoviedblistapp.presentation.showdetail.di.ShowDetailSubComponent
import com.rubenexposito.themoviedblistapp.presentation.showlist.ShowListActivity
import com.rubenexposito.themoviedblistapp.presentation.showlist.di.ShowListSubComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(ShowListActivity::class)
    abstract fun bindShowListActivityInjectorFactory(builder: ShowListSubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(ShowDetailActivity::class)
    abstract fun bindShowDetailActivityInjectorFactory(builder: ShowDetailSubComponent.Builder): AndroidInjector.Factory<out Activity>
}