package com.rubenexposito.themoviedblistapp.presentation.showdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.hide
import com.rubenexposito.themoviedblistapp.common.landscape
import com.rubenexposito.themoviedblistapp.common.load
import com.rubenexposito.themoviedblistapp.common.show
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.common.ShowListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_show_detail.*
import kotlinx.android.synthetic.main.layout_show_detail.*
import javax.inject.Inject

class ShowDetailActivity : AppCompatActivity(), ShowDetailContract.View {

    @Inject
    lateinit var presenter: ShowDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        AndroidInjection.inject(this)

        initExtra()
        initView()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun displayShow(tvShow: TvShow) {
        (ivImage as ImageView).load(if (landscape()) tvShow.imagePoster else tvShow.imageBackdrop)
        tvTitle.text = tvShow.title
        tvOverview.text = tvShow.overview
    }

    override fun displaySimilarShows(shows: List<TvShow>) {
        with(rvSimilarShows.adapter as ShowListAdapter){
            showlist.clear()
            showlist.addAll(shows)
            notifyDataSetChanged()
        }
    }

    override fun showLoading() {
        progressView.show()
        rvSimilarShows.hide()
    }

    override fun hideLoading() {
        progressView.hide()
        rvSimilarShows.show()
    }

    override fun showError(stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
    }

    private fun initExtra() {
        intent?.let {
            presenter.bindIntent(intent.getParcelableExtra(KEY_TV_SHOW))
        }
    }

    private fun initView() {
        with(rvSimilarShows){
            layoutManager = LinearLayoutManager(this@ShowDetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = ShowListAdapter(presenter, R.layout.item_similar_show)
        }
    }

    companion object {
        private const val KEY_TV_SHOW = "key:tvShow"

        fun getIntent(context: Context, tvShow: TvShow): Intent = Intent(context, ShowDetailActivity::class.java).run {
            putExtra(KEY_TV_SHOW, tvShow)
        }
    }
}
