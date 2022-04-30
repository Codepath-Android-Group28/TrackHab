package com.example.trackhab.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.trackhab.Habit
import com.example.trackhab.R
import com.parse.*
import com.parse.ParseException
import com.parse.ParseQuery
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date



class StatsFragment : Fragment() {

    lateinit var userCompletionRate: TextView
    lateinit var userStreak: TextView
    lateinit var userTotalHabits: TextView

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

        userCompletionRate = view.findViewById(R.id.userCompletionRate)
        userStreak = view.findViewById(R.id.userStreak)
        userTotalHabits = view.findViewById(R.id.userTotalHabits)

        queryUserHabits()
    }

    private fun queryUserHabits() {

        val query: ParseQuery<Habit> = ParseQuery.getQuery(Habit::class.java)

        // Conditions
        query.whereEqualTo(Habit.KEY_USER, ParseUser.getCurrentUser())

        query.findInBackground(object: FindCallback<Habit> {
            override fun done(habits: MutableList<Habit>?, e: ParseException?) {
                if (e == null) {

                    if (habits != null) {

                        var totalHabits = 0
                        var totalHabitsCompleted = 0
                        var currentHighestStreak = 0
                        var daysBetween: Long = 0

                        for (habit in habits) {
                            if (habit.getEndDate() != null) {
                                if (Date().getTime() < habit.getEndDate()!!.getTime())
                                    daysBetween = daysBetween(Date(), habit.getStartDate())
                                else
                                    daysBetween = daysBetween(habit.getEndDate()!!, habit.getStartDate())
                            }

                            // The number of days since a habit has started is the number of that habits (1 habit a day)
                            totalHabits += daysBetween.toInt()
                            totalHabitsCompleted += habit.getAmountCompleted()?.toInt() ?: 0

                            val highestStreak = habit.getHighestStreak()
                            if (highestStreak != null) {
                                if (highestStreak.toInt() > currentHighestStreak) {
                                    currentHighestStreak = highestStreak.toInt()
                                }
                            }
                        }
                        Log.i("StatsFragment", "totalHabits: " + totalHabits.toString())
                        Log.i("StatsFragment", "totalHabitsCompleted: " + totalHabitsCompleted.toString())

                        userCompletionRate.text = ( ((totalHabitsCompleted / totalHabits.toDouble()) * 1000).toInt() / 10.0 ).toString() + "%"
                        userTotalHabits.text = totalHabitsCompleted.toString()
                        userStreak.text = currentHighestStreak.toString()

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

    private fun daysBetween(date1: Date, date2: Date?): Long {
        if (date2 != null) {
            val diff: Long = date1.getTime() - date2.getTime()
            val seconds = diff / 1000
            val minutes = seconds / 60
            val hours = minutes / 60
            val days = hours / 24

            return days;
        }

        return -1;
    }
}