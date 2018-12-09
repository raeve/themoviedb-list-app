package com.rubenexposito.themoviedblistapp.presentation.common

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.inflate
import com.rubenexposito.themoviedblistapp.common.load
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import kotlinx.android.synthetic.main.item_show.view.*

class ShowListAdapter(private val callback: ShowListener? = null, @LayoutRes private val layoutRes: Int = R.layout.item_show) : RecyclerView.Adapter<ShowViewHolder>() {
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
        itemView.ivImage.setOnClickListener { callback?.onShowSelected(show) }
    }
}

interface ShowListener {
    fun onShowSelected(show: TvShow)
}

class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(show: TvShow) = with(itemView) {
        ivImage.load(show.imagePoster)
        tvTitle.text = show.title
        tvRating.text = show.rating.toString()
    }
}