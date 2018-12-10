package com.rubenexposito.themoviedblistapp.di

import android.app.Activity
import com.rubenexposito.themoviedblistapp.Navigator
import com.rubenexposito.themoviedblistapp.NavigatorImpl
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideNavigator(activity: Activity): Navigator = NavigatorImpl(activity)
    }
}