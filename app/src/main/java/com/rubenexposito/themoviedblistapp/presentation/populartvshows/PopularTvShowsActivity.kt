package com.rubenexposito.themoviedblistapp.presentation.populartvshows

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
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

    override fun showTvShows(tvShows: List<TvShow>) {
    }

    override fun addTvShows(tvShows: List<TvShow>) {
    }

    override fun showError(stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}
