package com.rubenexposito.themoviedblistapp.common

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.load(url: String?) = Picasso.get().load(url).into(this)

fun ImageView.loadWithCallback(url: String?, onSuccess: () -> Unit) =
    Picasso.get().load(url).noFade().into(this, object : Callback {
        override fun onSuccess() {
            onSuccess.invoke()
        }

        override fun onError(e: Exception?) {
            onSuccess.invoke()
        }
    })