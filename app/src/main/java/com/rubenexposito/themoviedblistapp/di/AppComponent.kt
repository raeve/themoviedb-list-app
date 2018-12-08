package com.rubenexposito.themoviedblistapp.di

import com.rubenexposito.contactsmarvelapp.di.AppModule
import com.rubenexposito.contactsmarvelapp.di.BuildersModule
import com.rubenexposito.themoviedblistapp.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (AppModule::class),
        (BuildersModule::class)
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: BaseApplication)
}