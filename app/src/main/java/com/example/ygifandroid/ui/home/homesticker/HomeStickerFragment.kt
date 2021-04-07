package com.example.ygifandroid.ui.home.homesticker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ygifandroid.R

class HomeStickerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_sticker, container, false)
    }

    companion object {

        fun newInstance() = HomeStickerFragment()
    }
}
