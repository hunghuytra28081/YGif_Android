package com.example.ygifandroid.ui.home.homegif

import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.data.source.remote.OnFetchDataJsonListener
import com.example.ygifandroid.data.source.repositories.GifRepository

class HomeGifPresenter(private val gifRepository: GifRepository) : HomeGifContract.Presenter {

    private var view: HomeGifContract.View? = null

    override fun getTrending() {
        gifRepository.getTrending(object : OnFetchDataJsonListener<MutableList<Gif>> {
            override fun onSuccess(data: MutableList<Gif>) {
                view?.onGetTrendingSuccess(data)
            }

            override fun onError(e: Exception?) {
                view?.onGetGifError(e)
            }
        })
    }

    override fun getRandom() {
        gifRepository.getRandom(object : OnFetchDataJsonListener<MutableList<Gif>> {
            override fun onSuccess(data: MutableList<Gif>) {
                view?.onGetRandomSuccess(data)
            }

            override fun onError(e: Exception?) {
                view?.onGetGifError(e)
            }

        })
    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: HomeGifContract.View?) {
        this.view = view
    }
}
