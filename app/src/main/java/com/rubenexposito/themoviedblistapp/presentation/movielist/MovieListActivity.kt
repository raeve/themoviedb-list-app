package com.rubenexposito.themoviedblistapp.presentation.movielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rubenexposito.themoviedblistapp.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MovieListActivity : AppCompatActivity(), MovieListContract.View {

    @Inject
    lateinit var presenter: MovieListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        AndroidInjection.inject(this)

        presenter.onCreate()
    }
}
