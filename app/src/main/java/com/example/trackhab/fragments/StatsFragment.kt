package com.example.trackhab.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trackhab.Habit
import com.example.trackhab.R
import com.parse.*
import com.parse.ParseException
import com.parse.ParseQuery


class StatsFragment : Fragment() {

    var allHabits: MutableList<Habit> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        queryUserHabits()
    }

    private fun queryUserHabits() {

        val query: ParseQuery<Habit> = ParseQuery.getQuery(Habit::class.java)

        // Conditions
        query.whereEqualTo(Habit.KEY_USER, ParseUser.getCurrentUser())

        query.findInBackground(object: FindCallback<Habit> {
            override fun done(habits: MutableList<Habit>?, e: ParseException?) {
                if (e == null) {

                    Log.i("StatsFragment", "Habit: " + habits.toString())

                    if (habits != null) {
                        allHabits.addAll(habits)
                    }

                    Log.i("StatsFragment", "Fetching Posts Successful")
                } else {
                    Log.e("StatsFragment", "Error fetching posts: " + e.message)
                    e.printStackTrace()
                }
            }

        })
    }
}