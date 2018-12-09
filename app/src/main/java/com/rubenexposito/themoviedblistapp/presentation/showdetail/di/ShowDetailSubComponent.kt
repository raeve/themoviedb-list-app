package com.rubenexposito.themoviedblistapp.presentation.showdetail.di

import com.rubenexposito.themoviedblistapp.di.ActivityModule
import com.rubenexposito.themoviedblistapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.presentation.showdetail.ShowDetailActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@PerActivity
@Subcomponent(modules = [ActivityModule::class, ShowDetailModule::class])
interface ShowDetailSubComponent : AndroidInjector<ShowDetailActivity>{
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ShowDetailActivity>()
}