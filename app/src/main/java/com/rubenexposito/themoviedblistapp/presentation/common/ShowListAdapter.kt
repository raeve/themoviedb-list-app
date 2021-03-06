package com.rubenexposito.themoviedblistapp.presentation.common

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.inflate
import com.rubenexposito.themoviedblistapp.common.load
import com.rubenexposito.themoviedblistapp.common.toPercentage
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import kotlinx.android.synthetic.main.item_show.view.*
import kotlinx.android.synthetic.main.layout_show_title_min.view.*

class ShowListAdapter(private val callback: ShowListener? = null, @LayoutRes private val layoutRes: Int = R.layout.item_show) :
    RecyclerView.Adapter<ShowViewHolder>() {
    var showlist: MutableList<TvShow> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShowViewHolder(parent.inflate(layoutRes))

    override fun getItemCount(): Int = showlist.size
    override fun getItemId(position: Int): Long = showlist[position].id.toLong()
    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) = with(holder) {
        val show = showlist[position]
        bind(show)
        with(itemView){
            ivImage.setOnClickListener {
                callback?.onShowSelected(show, ivImage)
            }
        }
    }
}

interface ShowListener {
    fun onShowSelected(show: TvShow, imageView: ImageView)
}

class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(show: TvShow) = with(itemView) {
        ivImage.transitionName = show.id.toString()
        ivImage.load(show.imagePoster)
        tvTitle.text = show.title
        tvRating.text = show.rating.toPercentage()
    }
}