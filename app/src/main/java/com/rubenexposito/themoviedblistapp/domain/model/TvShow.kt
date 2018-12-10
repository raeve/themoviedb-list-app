package com.rubenexposito.themoviedblistapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(val id: Int,
                  val title: String,
                  val overview: String? = null,
                  val imageBackdrop: String? = null,
                  val imagePoster: String? = null,
                  val rating: Double = 0.0,
                  val popularity: Double = 0.0,
                  val year: Int = 2018) : Parcelable