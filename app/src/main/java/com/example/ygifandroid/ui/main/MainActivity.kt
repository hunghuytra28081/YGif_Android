package com.example.ygifandroid.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ygifandroid.R
import com.example.ygifandroid.ui.main.page.PageContainerFragment
import com.example.ygifandroid.utils.addFragment

class MainActivity : AppCompatActivity() {

    private var isDoubleBackPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(R.id.containerLayout, PageContainerFragment.newInstance())
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else if (!isDoubleBackPressed) {
            this.isDoubleBackPressed = true
            Toast.makeText(this, R.string.back_again, Toast.LENGTH_SHORT).show()
            Handler(Looper.getMainLooper()).postDelayed({ isDoubleBackPressed = false }, DELAY_TIME)
            return
        } else {
            super.onBackPressed()
            return
        }
    }

    companion object {
        const val DELAY_TIME = 2000L
    }
}
