package com.rubenexposito.themoviedblistapp.presentation.showlist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.hide
import com.rubenexposito.themoviedblistapp.common.landscape
import com.rubenexposito.themoviedblistapp.common.show
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import com.rubenexposito.themoviedblistapp.presentation.common.ShowListAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_show_list.*
import kotlinx.android.synthetic.main.layout_empty.*
import kotlinx.android.synthetic.main.view_progress.*
import kotlinx.android.synthetic.main.view_toolbar.*
import javax.inject.Inject

class ShowListActivity : AppCompatActivity(), ShowListContract.View {
    @Inject
    lateinit var presenter: ShowListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        AndroidInjection.inject(this)

        initView()
        presenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        ivToolbar.setImageDrawable(getDrawable(R.drawable.ic_tmdb_stacked))
        tvToolbar.text = getString(R.string.title_popular_tv_shows)
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun showTvShows(tvShows: List<TvShow>) {
        rvShowList.show()
        with(rvShowList.adapter as ShowListAdapter) {
            showlist.clear()
            showlist.addAll(tvShows)
            notifyDataSetChanged()
        }
    }

    override fun addTvShows(tvShows: List<TvShow>) {
        with(rvShowList.adapter as ShowListAdapter) {
            val size = itemCount
            showlist.addAll(tvShows)
            notifyItemRangeInserted(size, tvShows.size)
        }

    }

    override fun showError(stringRes: Int) {
        if(rvShowList.adapter?.itemCount == 0) {
            viewEmpty.show()
        }
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        rvShowList.hide()
        viewToolbar.hide()
        viewEmpty.hide()
        srlShowList.isRefreshing = false
        progressView.show()
    }

    override fun hideLoading() {
        viewToolbar.show()
        srlShowList.isRefreshing = false
        progressView.hide()
    }

    private fun initView() {
        with(srlShowList) {
            setOnRefreshListener { presenter.requestData(true) }
        }

        with(rvShowList) {
            val spanCount = if (this@ShowListActivity.landscape()) 3 else 2
            val gridLayoutManager = GridLayoutManager(this@ShowListActivity, spanCount)
            layoutManager = gridLayoutManager
            adapter = ShowListAdapter(presenter)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (gridLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                        viewToolbar.show()
                    } else {
                        viewToolbar.hide()
                    }

                    if (gridLayoutManager.findLastVisibleItemPosition() >= gridLayoutManager.itemCount - (spanCount * 3)) {
                        presenter.requestData(false)
                    }
                    super.onScrollStateChanged(recyclerView, newState)
                }
            })
            setHasFixedSize(true)
        }
    }
}
