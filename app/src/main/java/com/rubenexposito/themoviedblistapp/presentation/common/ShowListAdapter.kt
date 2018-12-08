package com.rubenexposito.themoviedblistapp.presentation.common

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rubenexposito.themoviedblistapp.R
import com.rubenexposito.themoviedblistapp.common.inflate
import com.rubenexposito.themoviedblistapp.domain.model.TvShow

class ShowListAdapter(private val callback: ShowListener? = null) : RecyclerView.Adapter<ShowViewHolder>() {
    var showlist: MutableList<TvShow> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ShowViewHolder(parent.inflate(R.layout.item_show))

    override fun getItemCount(): Int = showlist.size
    override fun getItemId(position: Int): Long = showlist[position].id.toLong()
    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) = with(holder) {
        val show = showlist[position]
        bind(show)
        itemView.setOnClickListener { callback?.onShowSelected(show) }
    }

    fun addShows(shows: List<TvShow>) {
        this.showlist.addAll(shows)
    }
}

interface ShowListener {
    fun onShowSelected(show: TvShow)
}

class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(show: TvShow) = with(itemView) {

    }
}