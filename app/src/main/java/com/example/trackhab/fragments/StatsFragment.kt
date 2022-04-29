package com.example.trackhab.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.trackhab.Habit
import com.example.trackhab.R
import com.parse.*
import java.io.File
import java.util.*

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


        // TODO: Remove Below Code
        login()
        submitHabit()
        queryUserHabits()
    }

    fun login() {
        ParseUser.logInInBackground("testUser", "password", ({ user, e ->
            if (user != null) {
                Log.i("StatsFragment", "Logged in Successfully")
                Log.i("StatsFragment", "User: " + ParseUser.getCurrentUser())
            } else {
                e.printStackTrace()
                Log.e("StatsFragment", "Logged in Failed")
            }})
        )
    }

    fun submitHabit() {
        val habit = Habit()
        habit.setUserId(ParseUser.getCurrentUser())
        habit.setHabitName("Jumping")
        habit.setStartDate(Date())
        habit.setCount(420)
        habit.setTarget(1000)
        habit.setCompleted(false)
        habit.saveInBackground { exception ->
            if (exception == null) {
                Log.i("StatsFragment", "Successfully saved habit")
            } else {
                Log.e("StatsFragment", "Error while saving post")
            }
        }
    }

    private fun queryUserHabits() {

        val query: ParseQuery<Habit> = ParseQuery.getQuery(Habit::class.java)

        // Might be able to get this data from a different query in a different fragment
//        query.whereEqualTo(Habit.KEY_USER, ParseUser.getCurrentUser())

        query.findInBackground(object: FindCallback<Habit> {
            override fun done(objects: MutableList<Habit>?, e: ParseException?) {
                if (e == null) {
                    // TODO: Successful query
                    Log.i("StatsFragment", "Fetching Posts Successful")
                } else {
                    Log.e("StatsFragment", "Error fetching posts")
                    e.printStackTrace()
                }
            }

        })
    }
}