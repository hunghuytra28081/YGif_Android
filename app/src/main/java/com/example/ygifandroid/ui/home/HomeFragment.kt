package com.example.ygifandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.ygifandroid.R
import com.example.ygifandroid.ui.home.homegif.HomeGifFragment
import com.example.ygifandroid.ui.home.homesticker.HomeStickerFragment
import com.example.ygifandroid.ui.home.hometext.HomeTextFragment
import com.example.ygifandroid.utils.MenuHomeContainerItem
import kotlinx.android.synthetic.main.fragment_home.*
import nl.joery.animatedbottombar.AnimatedBottomBar


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentManager?.let {
            viewPagerContainerHome.apply {
                offscreenPageLimit = 3
                adapter = HomeAdapter(it).apply {
                    addFragment(HomeGifFragment.newInstance())
                    addFragment(HomeTextFragment.newInstance())
                    addFragment(HomeStickerFragment.newInstance())
                }
            }
        }

        initItemTopBar()

    }

    private fun initItemTopBar() {
        animatedBottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newTab.id) {
                    R.id.gifItem -> {
                        viewPagerContainerHome.currentItem = MenuHomeContainerItem.GIF.ordinal
                    }
                    R.id.textItem -> {
                        viewPagerContainerHome.currentItem = MenuHomeContainerItem.TEXT.ordinal
                    }
                    R.id.stickerItem -> {
                        viewPagerContainerHome.currentItem = MenuHomeContainerItem.STICKER.ordinal
                    }
                }
            }
        })
        viewPagerContainerHome.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                animatedBottomBar.selectTab(animatedBottomBar.tabs[position])
            }

            override fun onPageScrollStateChanged(state: Int) = Unit

        })
    }

    companion object {

        fun newInstance() = HomeFragment()
    }
}
