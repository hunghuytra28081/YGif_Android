package com.example.ygifandroid.data.source.remote

import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.data.model.GifEntry
import com.example.ygifandroid.data.source.GifDataSource
import com.example.ygifandroid.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.ygifandroid.utils.Constant

class GifRemoteDataSource : GifDataSource.Remote {

    override fun getTrending(listener: OnFetchDataJsonListener<MutableList<Gif>>) {
        val trendingUrl = Constant.BASE_URL +
                Constant.TYPE_GIF +
                Constant.TRENDING +
                Constant.BASE_API_KEY +
                Constant.LIMIT
        GetJsonFromUrl(listener, GifEntry.GIF).execute(trendingUrl)
    }

    override fun getRandom(listener: OnFetchDataJsonListener<MutableList<Gif>>) {
        val randomUrl = Constant.BASE_URL +
                Constant.TYPE_GIF +
                Constant.TRENDING +
                Constant.BASE_API_KEY +
                Constant.LIMIT_20 +
                Constant.OFFSET +
                Constant.PAGE.toString()
        GetJsonFromUrl(listener, GifEntry.GIF).execute(randomUrl)
    }

    companion object {
        @Volatile
        private var instance: GifRemoteDataSource? = null

        fun getInstance(): GifRemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: GifRemoteDataSource().also {
                    instance = it
                }
            }
    }
}
