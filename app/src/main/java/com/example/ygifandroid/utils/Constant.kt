package com.example.ygifandroid.utils

import com.example.ygifandroid.BuildConfig

object Constant {
    const val BASE_URL = "https://api.giphy.com/v1/"
    const val BASE_API_KEY = "?api_key=" + BuildConfig.API_KEY
    const val TYPE_GIF = "gifs/"
    const val TYPE_TEXT = "text/"
    const val TRENDING = "trending"
    const val SEARCH = "search"
    const val LIMIT = "&limit=10"
    const val LIMIT_20 = "&limit=20"
    const val OFFSET = "&offset="
    const val PAGE = 20
    const val KEYWORD = "&q="
    const val BUNDLE_GIF = "gifDetail"
}
