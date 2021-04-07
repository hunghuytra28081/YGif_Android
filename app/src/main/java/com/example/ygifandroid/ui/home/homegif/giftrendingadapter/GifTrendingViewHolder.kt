package com.example.ygifandroid.ui.home.homegif.giftrendingadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ygifandroid.R
import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.utils.loadGifUrl
import com.example.ygifandroid.utils.loadImageUrl
import kotlinx.android.synthetic.main.item_gif_trending.view.*


class GifTrendingViewHolder(
    viewGroup: ViewGroup
) : RecyclerView.ViewHolder(newInstance(viewGroup)) {

    fun onBind(gif: Gif) {
        with(itemView) {
            userNameTextView.text = gif.user.name
            dateTimeTextView.text = gif.dateTime
            gifImageView.loadGifUrl(gif.imageUrl)
            userImageView.loadImageUrl(gif.user.avatarUrl)
        }
    }

    fun registerItemViewHolderListener(listener: (Int) -> Unit) {
        itemView.gifImageView.setOnClickListener {
            listener(adapterPosition)
        }
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup): View {
            return LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_gif_trending, viewGroup, false)
        }
    }
}
