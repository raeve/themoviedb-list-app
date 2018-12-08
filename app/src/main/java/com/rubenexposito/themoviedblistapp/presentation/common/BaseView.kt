package com.rubenexposito.themoviedblistapp.presentation.common

import androidx.annotation.StringRes

interface BaseView {
    fun showError(@StringRes stringRes: Int)
    fun showLoading()
    fun hideLoading()
}