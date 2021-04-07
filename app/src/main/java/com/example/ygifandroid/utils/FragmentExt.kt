package com.example.ygifandroid.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.addFragment(id: Int, fragment: Fragment) {
    supportFragmentManager.inTransaction { add(id, fragment) }
}

fun AppCompatActivity.replaceFragment(id: Int, fragment: Fragment) {
    supportFragmentManager.inTransaction { replace(id, fragment) }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment) }
}

fun Fragment.addFragment(id: Int, fragment: Fragment) {
    fragmentManager?.inTransaction { add(id, fragment).addToBackStack(null) }
}

fun Fragment.replaceFragment(id: Int, fragment: Fragment) {
    fragmentManager?.inTransaction { replace(id, fragment).addToBackStack(null) }
}

fun Fragment.removeFragment(fragment: Fragment) {
    fragmentManager?.inTransaction { remove(fragment) }
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}
