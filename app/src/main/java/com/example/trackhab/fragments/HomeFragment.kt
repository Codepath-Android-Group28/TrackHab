package com.example.trackhab.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trackhab.Adapter
import com.example.trackhab.Habit
import com.example.trackhab.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser
import java.util.*

class HomeFragment : Fragment() {

    lateinit var postRecyclerView: RecyclerView

    lateinit var adapter: Adapter

    var allHabits: MutableList<Habit> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Setup logics

        postRecyclerView = view.findViewById(R.id.postRecyclerView)
        adapter= Adapter(requireContext(), allHabits)
        postRecyclerView.adapter = adapter
        postRecyclerView.layoutManager=LinearLayoutManager(requireContext())

        queryUserHabits()

    }

    private fun queryUserHabits() {

        val query: ParseQuery<Habit> = ParseQuery.getQuery(Habit::class.java)

        // Conditions
        query.whereEqualTo(Habit.KEY_USER, ParseUser.getCurrentUser())

        query.findInBackground(object: FindCallback<Habit> {
            override fun done(habits: MutableList<Habit>?, e: ParseException?) {
                if (e != null) {

                    Log.e("StatsFragment", "Error fetching posts: " + e.message)
                }
                else{
                    if (habits != null) {
                        for (habit in habits) {
                            Log.i(
                                "Test",
                                "Habit:" + habit.getHabitName() + ",Status:" + habit.getCompleted()
                            )
                        }
                        Log.i("StatsFragment", "Fetching Posts Successful")
                        allHabits.addAll(habits)
                        adapter.notifyDataSetChanged()
                    }
                    }
                }
        })
    }
}