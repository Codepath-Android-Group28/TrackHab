package com.example.trackhab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.trackhab.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item->
            var fragmentToShow: Fragment?=null
            when(item.itemId){
                R.id.action_home->{
                    fragmentToShow = HomeFragment()
                    Toast.makeText(this, "Home",Toast.LENGTH_SHORT).show()
                }
                R.id.action_add->{
                    Toast.makeText(this, "Add",Toast.LENGTH_SHORT).show()
                }
                R.id.action_stats->{
                    Toast.makeText(this, "Stats",Toast.LENGTH_SHORT).show()
                }
            }
            if (fragmentToShow != null){
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()

            }

            true
        }

        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home
    }
}