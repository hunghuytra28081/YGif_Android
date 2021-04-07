package com.example.ygifandroid.data.source.repositories

import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.data.source.GifDataSource
import com.example.ygifandroid.data.source.remote.OnFetchDataJsonListener

class GifRepository(
    private val remote: GifDataSource.Remote
) {

    fun getTrending(listener: OnFetchDataJsonListener<MutableList<Gif>>) =
        remote.getTrending(listener)

    fun getRandom(listener: OnFetchDataJsonListener<MutableList<Gif>>) =
        remote.getRandom(listener)

    companion object {
        @Volatile
        private var instance: GifRepository? = null

        fun getInstance(
            remote: GifDataSource.Remote
        ): GifRepository = instance ?: synchronized(this) {
            instance ?: GifRepository(remote).also {
                instance = it
            }
        }
    }
}
