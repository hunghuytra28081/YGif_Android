package com.example.ygifandroid.ui.home.hometext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ygifandroid.R

class HomeTextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_text, container, false)
    }

    companion object {

        fun newInstance() = HomeTextFragment()
    }
}
