package com.example.trackhab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.trackhab.fragments.StatsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.trackhab.fragments.HomeFragment
import com.parse.ParseObject
import com.parse.GetCallback

import com.parse.ParseQuery




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener { item ->

            var fragmentToShow: Fragment? = null
            when (item.itemId) {
                R.id.action_home -> {
                    fragmentToShow = HomeFragment()
                }
                //R.id.action_add->{
                //  fragmentToShow = ComposeFragment()
                // }
                R.id.action_stats -> {
                    fragmentToShow = StatsFragment()
                }
            }

            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow)
                    .commit()
            }
            true
        }
    }
}