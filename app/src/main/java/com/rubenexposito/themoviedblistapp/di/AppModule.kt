package com.rubenexposito.themoviedblistapp.di

import android.content.Context
import com.rubenexposito.themoviedblistapp.BaseApplication
import com.rubenexposito.themoviedblistapp.common.Mockable
import com.rubenexposito.themoviedblistapp.presentation.showdetail.di.ShowDetailSubComponent
import com.rubenexposito.themoviedblistapp.presentation.showlist.di.ShowListSubComponent
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Mockable
@Module(
    subcomponents = [ShowListSubComponent::class, ShowDetailSubComponent::class]
)
class AppModule {

    @Provides
    fun context(application: BaseApplication): Context = application.applicationContext

    @Provides
    @Named("observeOn")
    fun provideObserveOnScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named("subscribeOn")
    fun provideSubscribeOnScheduler(): Scheduler = Schedulers.io()

}

