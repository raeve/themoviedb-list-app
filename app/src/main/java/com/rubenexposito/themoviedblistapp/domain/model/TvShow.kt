package com.rubenexposito.themoviedblistapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(val id: Int, val title: String, val overview: String, val imageBackdrop: String, val imagePoster: String, val rating: Double) :
    Parcelable