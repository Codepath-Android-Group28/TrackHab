package com.example.trackhab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context, val habits: List<Habit>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_habit, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val habit=habits.get(position)
        holder.bind(habit)
    }

    override fun getItemCount(): Int {
        return habits.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val habitName: TextView
        val status: TextView

        init {
            habitName=itemView.findViewById(R.id.habitName)
            status=itemView.findViewById(R.id.switch1)
        }

        fun bind(habit: Habit){
            habitName.text=habit.getHabitName()
            status.text=habit.getCompleted().toString()

        }
    }
}