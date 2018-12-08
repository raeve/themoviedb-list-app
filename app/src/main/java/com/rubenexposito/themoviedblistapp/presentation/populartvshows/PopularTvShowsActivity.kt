package com.rubenexposito.themoviedblistapp.presentation.populartvshows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rubenexposito.themoviedblistapp.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class PopularTvShowsActivity : AppCompatActivity(), PopularTvShowsContract.View {

    @Inject
    lateinit var presenter: PopularTvShowsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        AndroidInjection.inject(this)

        presenter.onCreate()
    }
}
