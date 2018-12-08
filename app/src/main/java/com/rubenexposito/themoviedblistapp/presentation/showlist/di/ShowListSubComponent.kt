package com.rubenexposito.themoviedblistapp.presentation.showlist.di

import com.rubenexposito.themoviedblistapp.di.PerActivity
import com.rubenexposito.themoviedblistapp.di.ActivityModule
import com.rubenexposito.themoviedblistapp.presentation.showlist.ShowListActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerActivity
@Subcomponent(modules = [ActivityModule::class, ShowListModule::class])
interface ShowListSubComponent : AndroidInjector<ShowListActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ShowListActivity>()
}