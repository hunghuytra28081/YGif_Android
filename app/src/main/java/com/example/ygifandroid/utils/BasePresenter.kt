package com.example.ygifandroid.utils

interface BasePresenter<T> {

    fun onStart()

    fun onStop()

    fun setView(view: T?)
}
