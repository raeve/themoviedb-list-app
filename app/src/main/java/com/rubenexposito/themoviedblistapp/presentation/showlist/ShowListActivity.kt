package com.rubenexposito.themoviedblistapp.presentation.showlist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.hide
import com.rubenexposito.themoviedblistapp.common.show
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.view_progress.*
import javax.inject.Inject

class ShowListActivity : AppCompatActivity(), ShowListContract.View {
    @Inject
    lateinit var presenter: ShowListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        AndroidInjection.inject(this)

        presenter.onCreate()

    }

    override fun showTvShows(tvShows: List<TvShow>) {
        Toast.makeText(this, "show data", Toast.LENGTH_SHORT).show()

    }

    override fun addTvShows(tvShows: List<TvShow>) {
        Toast.makeText(this, "add data", Toast.LENGTH_SHORT).show()

    }

    override fun showError(stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressView.show()
    }

    override fun hideLoading() {
        progressView.hide()
    }
}
