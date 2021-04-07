package com.example.ygifandroid.ui.home.homegif

import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.utils.BasePresenter

interface HomeGifContract {
    interface Presenter : BasePresenter<View> {

        fun getTrending()

        fun getRandom()
    }

    interface View {

        fun onGetTrendingSuccess(gifs: MutableList<Gif>)

        fun onGetRandomSuccess(gifs: MutableList<Gif>)

        fun onGetGifError(e: Exception?)
    }
}
