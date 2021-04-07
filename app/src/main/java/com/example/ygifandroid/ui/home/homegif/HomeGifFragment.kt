package com.example.ygifandroid.ui.home.homegif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ygifandroid.R
import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.data.source.remote.GifRemoteDataSource
import com.example.ygifandroid.data.source.repositories.GifRepository
import com.example.ygifandroid.ui.home.homegif.gifrandomadapter.GifRandomAdapter
import com.example.ygifandroid.ui.home.homegif.giftrendingadapter.GifTrendingAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_gif.*

class HomeGifFragment : Fragment(), HomeGifContract.View {

    private val gifTrendingAdapter by lazy { GifTrendingAdapter() }

    private val gifRandomAdapter by lazy { GifRandomAdapter() }

    private val presenter by lazy {
        HomeGifPresenter(
            GifRepository.getInstance(
                GifRemoteDataSource.getInstance()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_gif, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        presenter.run {
            setView(this@HomeGifFragment)
            getTrending()
            getRandom()
        }
    }

    override fun onGetTrendingSuccess(gifs: MutableList<Gif>) {
        gifTrendingAdapter.addGifTrending(gifs)
    }

    override fun onGetRandomSuccess(gifs: MutableList<Gif>) {
        gifRandomAdapter.addGifRandom(gifs)
    }

    override fun onGetGifError(e: Exception?) = Unit

    private fun initView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        trendingRecyclerView.adapter = gifTrendingAdapter
        randomRecyclerView.adapter = gifRandomAdapter
        trendingRecyclerView.setHasFixedSize(true)
        randomRecyclerView.setHasFixedSize(true)

    }

    companion object {

        fun newInstance() = HomeGifFragment()
    }
}
