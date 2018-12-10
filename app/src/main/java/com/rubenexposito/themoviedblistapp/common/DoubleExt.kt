package com.rubenexposito.themoviedblistapp.common

fun Double.toPercentage() = "${(this * 10).toInt()}%"

fun Double.toKilos() = "${this.toInt()}k"