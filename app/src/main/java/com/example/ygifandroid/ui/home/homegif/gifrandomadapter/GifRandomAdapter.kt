package com.example.ygifandroid.ui.home.homegif.gifrandomadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ygifandroid.data.model.Gif

class GifRandomAdapter : RecyclerView.Adapter<GifRandomViewHolder>() {

    private val gifs = mutableListOf<Gif>()
    private var listener: ((Gif) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifRandomViewHolder {
        return GifRandomViewHolder(parent).apply {
            registerItemViewHolderListener {
                listener?.let { func -> func(gifs[it]) }
            }
        }
    }

    override fun onBindViewHolder(holder: GifRandomViewHolder, position: Int) {
        holder.onBind(gifs[position])
    }

    override fun getItemCount() = gifs.size

    fun addGifRandom(items: MutableList<Gif>?) {
        items?.let {
            gifs.addAll(it)
            notifyItemRangeInserted(this.gifs.size - it.size, it.size)
        }
    }

    fun setOnClickItemListener(listener: ((Gif) -> Unit)) {
        this.listener = listener
    }
}
