package com.rubenexposito.themoviedblistapp.presentation.showdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.*
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.common.ShowListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_show_detail.*
import kotlinx.android.synthetic.main.layout_show_overview.*
import kotlinx.android.synthetic.main.layout_show_title.*
import kotlinx.android.synthetic.main.view_toolbar.*
import javax.inject.Inject

class ShowDetailActivity : AppCompatActivity(), ShowDetailContract.View {

    @Inject
    lateinit var presenter: ShowDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        AndroidInjection.inject(this)
        supportPostponeEnterTransition()
        initExtra()
        initView()
    }

    override fun onResume() {
        super.onResume()
        ivToolbar.setImageDrawable(getDrawable(R.drawable.ic_back))
        tvToolbar.text = ""
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun displayShow(tvShow: TvShow) {
        with(tvShow) {
            (ivImage as ImageView).transitionName = id.toString()
            (ivImage as ImageView).loadWithCallback(if (landscape()) imagePoster else imageBackdrop) { supportStartPostponedEnterTransition() }
            tvTitle.text = title
            tvDate.text = year.toString()
            tvRating.text = rating.toPercentage()
            tvPopularity.text = popularity.toKilos()
            tvOverview.text = overview
        }
    }

    override fun displaySimilarShows(shows: List<TvShow>) {
        llSimilar.show()
        lavSimilar.hide()
        with(rvSimilarShows.adapter as ShowListAdapter) {
            showlist.clear()
            showlist.addAll(shows)
            notifyDataSetChanged()
        }
    }

    override fun displayEmptySimilarShows() {
        llSimilar.hide()
        lavSimilar.show()
    }

    private fun initExtra() {
        intent?.let {
            val tvShow = intent.getParcelableExtra<TvShow>(KEY_TV_SHOW)
            displayShow(tvShow)
            presenter.bindIntent(tvShow.id)
        }
    }

    private fun initView() {
        with(rvSimilarShows) {
            layoutManager = LinearLayoutManager(this@ShowDetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = ShowListAdapter(presenter, R.layout.item_similar_show)
        }

        ivToolbar.setOnClickListener { finish() }
    }

    companion object {
        private const val KEY_TV_SHOW = "key:tvShow"

        fun getIntent(context: Context, tvShow: TvShow): Intent = Intent(context, ShowDetailActivity::class.java).run {
            putExtra(KEY_TV_SHOW, tvShow)
        }
    }
}
