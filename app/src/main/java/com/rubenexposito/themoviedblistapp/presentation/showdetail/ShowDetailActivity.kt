package com.rubenexposito.themoviedblistapp.presentation.showdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.landscape
import com.rubenexposito.themoviedblistapp.common.load
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_show_detail.*
import javax.inject.Inject

class ShowDetailActivity : AppCompatActivity(), ShowDetailContract.View {

    @Inject
    lateinit var presenter: ShowDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        AndroidInjection.inject(this)

        initExtra()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun displayShow(tvShow: TvShow) {
        val imageUrl = if (landscape()) tvShow.imagePoster else tvShow.imageBackdrop
        findViewById<ImageView>(R.id.ivImage).load(imageUrl)
        tvTitle.text = tvShow.title
        tvOverview.text = tvShow.overview
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(stringRes: Int) {
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
    }

    private fun initExtra() {
        intent?.let {
            presenter.bindIntent(intent.getParcelableExtra(KEY_TV_SHOW))
        }
    }

    companion object {
        private const val KEY_TV_SHOW = "key:tvShow"

        fun getIntent(context: Context, tvShow: TvShow): Intent = Intent(context, ShowDetailActivity::class.java).run {
            putExtra(KEY_TV_SHOW, tvShow)
        }
    }
}
