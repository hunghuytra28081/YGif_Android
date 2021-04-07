package com.example.ygifandroid.ui.home.homegif.gifrandomadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.ygifandroid.R
import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.utils.loadGifUrl
import kotlinx.android.synthetic.main.item_gif_random.view.*

class GifRandomViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun onBind(gif: Gif){
        itemView.relatedImageView.loadGifUrl(gif.imageUrl)
    }

    fun registerItemViewHolderListener(listener: (Int) -> Unit) {
        itemView.relatedImageView.setOnClickListener {
            listener(adapterPosition)
        }
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_gif_random, viewGroup, false)
        }
    }
}