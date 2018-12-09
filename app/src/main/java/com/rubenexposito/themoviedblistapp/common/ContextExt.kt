package com.rubenexposito.themoviedblistapp.common

import android.content.Context
import android.content.res.Configuration

fun Context.landscape(): Boolean = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE