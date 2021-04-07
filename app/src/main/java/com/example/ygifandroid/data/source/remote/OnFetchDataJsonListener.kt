package com.example.ygifandroid.data.source.remote

import java.lang.Exception

interface OnFetchDataJsonListener<T> {

    fun onSuccess(data: T)

    fun onError(e: Exception?)
}
