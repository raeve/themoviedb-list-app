package com.rubenexposito.themoviedblistapp.common

import android.content.Context
import android.content.res.Configuration
import com.rubenexposito.themoviedblistapp.BaseApplication
import java.util.*

fun Context.landscape(): Boolean = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

fun Locale.serverLanguage() : String = "$language-$country"

fun Context.asApp() = applicationContext as BaseApplication