package com.example.trackhab.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trackhab.Habit
import com.example.trackhab.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery

class StatsFragment : Fragment() {

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

        // Might be able to get this data from a different query in a different fragment
        query.include(Habit.KEY_USER)

        query.findInBackground(object: FindCallback<Habit> {
            override fun done(objects: MutableList<Habit>?, e: ParseException?) {
                if (e == null) {
                    // TODO: Successful query

                } else {
                    Log.e("StatsFragment", "Error fetching posts")
                    e.printStackTrace()
                }
            }

        })
    }
}