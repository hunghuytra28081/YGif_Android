package com.example.ygifandroid.ui.main.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.ygifandroid.R
import com.example.ygifandroid.ui.home.HomeFragment
import com.example.ygifandroid.ui.search.SearchFragment
import com.example.ygifandroid.ui.storage.StorageFragment
import com.example.ygifandroid.utils.MenuViewContainerItem
import com.example.ygifandroid.utils.hideKeyboard
import kotlinx.android.synthetic.main.fragment_container_page.*

class PageContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentManager?.let {
            viewPagerContainer.apply {
                adapter = ViewPagerContainerAdapter(it).apply {
                    addFragment(HomeFragment.newInstance())
                    addFragment(SearchFragment.newInstance())
                    addFragment(StorageFragment.newInstance())
                }
                offscreenPageLimit = OFF_SCREEN_PAGE_LIMIT
            }
        }
        initItemBottomBar()
    }

    private fun initItemBottomBar() {
        bottomNavigationView.apply {
            setItemSelected(R.id.homeItem, true)
            setOnItemSelectedListener {
                when (it) {
                    R.id.homeItem -> {
                        viewPagerContainer.currentItem = MenuViewContainerItem.HOME.ordinal
                    }
                    R.id.searchItem -> {
                        viewPagerContainer.currentItem = MenuViewContainerItem.SEARCH.ordinal
                    }
                    R.id.storageItem -> {
                        viewPagerContainer.currentItem = MenuViewContainerItem.STORAGE.ordinal
                    }
                }
            }
        }

        viewPagerContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                bottomNavigationView.setItemSelected(bottomNavigationView[position].id)
                hideKeyboard()
            }

            override fun onPageScrollStateChanged(state: Int) = Unit
        })
    }

    companion object {
        private const val OFF_SCREEN_PAGE_LIMIT = 3

        fun newInstance() = PageContainerFragment()
    }
}
