package com.example.albumlistapplication.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import com.example.albumlistapplication.R
import com.example.albumlistapplication.ui.main.albums.AlbumsFragment

class MainActivity : WolmoActivity() {
    override fun init() {
        replaceFragment(AlbumsFragment(), R.id.vBaseContent, false, "Albums List")
    }

    override fun layout(): Int = R.layout.activity_base

    fun replaceFragment(
        fragment: Fragment, resId: Int,
        addToBackStack: Boolean, title: String?
    ): Fragment? {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val manager: FragmentManager = supportFragmentManager
        transaction.replace(resId, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()
        setTitle(title)
        return fragment
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0)
            finish()
        else {
            if (supportFragmentManager.backStackEntryCount > 1)
                supportFragmentManager.popBackStack()
            else
                super.onBackPressed()
        }
    }
}