package com.rubenexposito.themoviedblistapp

import android.app.Activity

interface Navigator {
}

class NavigatorImpl(private val activity: Activity) : Navigator {
}