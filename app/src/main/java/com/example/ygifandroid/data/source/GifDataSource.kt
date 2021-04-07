package com.example.ygifandroid.data.source

import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.data.source.remote.OnFetchDataJsonListener

interface GifDataSource {

    interface Remote {

        fun getTrending(listener: OnFetchDataJsonListener<MutableList<Gif>>)

        fun getRandom(listener: OnFetchDataJsonListener<MutableList<Gif>>)
    }
}
