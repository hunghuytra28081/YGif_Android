package com.example.ygifandroid.ui.home.homegif.giftrendingadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ygifandroid.data.model.Gif

class GifTrendingAdapter : RecyclerView.Adapter<GifTrendingViewHolder>() {

    private val gifs = mutableListOf<Gif>()
    private var listener: ((Gif) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifTrendingViewHolder {
        return GifTrendingViewHolder(parent).apply {
            registerItemViewHolderListener {
                listener?.let { function -> function(gifs[it]) }
            }
        }
    }

    override fun onBindViewHolder(holder: GifTrendingViewHolder, position: Int) {
        holder.onBind(gifs[position])
    }

    override fun getItemCount() = gifs.size

    fun addGifTrending(items: MutableList<Gif>?) {
        items?.let {
            gifs.addAll(it)
            notifyItemRangeInserted(this.gifs.size - it.size, it.size)
        }
    }

    fun setOnClickItemListener(listener: (Gif) -> Unit) {
        this.listener = listener
    }
}
