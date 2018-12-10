package com.rubenexposito.themoviedblistapp.di

import com.rubenexposito.themoviedblistapp.BaseApplication
import com.rubenexposito.themoviedblistapp.common.Mockable
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Mockable
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        BuildersModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun appModule(appModule: AppModule): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent
    }

    fun inject(application: BaseApplication)
}