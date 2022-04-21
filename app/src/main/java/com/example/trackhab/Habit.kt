package com.example.trackhab

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser
import java.util.Date

@ParseClassName("Habit")
class Habit : ParseObject() {

    fun getUserID(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    fun setUserId(parseUser: ParseUser) {
        put(KEY_USER, parseUser)
    }

    fun getHabitName(): String? {
        return getString(KEY_HABIT_NAME)
    }

    fun setHabitName(habitName: String) {
        put(KEY_HABIT_NAME, habitName)
    }

    fun getStartDate(): Date? {
        return getDate(KEY_START_DATE)
    }

    fun setStartDate(date: Date) {
        put(KEY_START_DATE, date)
    }

    fun getEndDate(): Date? {
        return getDate(KEY_END_DATE)
    }

    fun setEndDate(date: Date) {
        put(KEY_END_DATE, date)
    }

    fun getCount(): Number? {
        return getNumber(KEY_COUNT)
    }

    fun setCount(count: Number) {
        put(KEY_COUNT, count)
    }

    fun getTarget(): Number? {
        return getNumber(KEY_TARGET)
    }

    fun setTarget(target: Number) {
        put(KEY_TARGET, target)
    }

    fun getUnit(): String? {
        return getString(KEY_UNIT)
    }

    fun setUnit(unit: String) {
        put(KEY_UNIT, unit)
    }

    fun getCompleted(): Boolean? {
        return getBoolean(KEY_COMPLETED)
    }

    fun setCompleted(completed: Boolean) {
        put(KEY_COMPLETED, completed)
    }

    companion object {
        const val KEY_USER = "user"
        const val KEY_HABIT_NAME = "habitName"
        const val KEY_START_DATE = "startDate"
        const val KEY_END_DATE = "endDate"
        const val KEY_COUNT = "count"
        const val KEY_TARGET = "target"
        const val KEY_UNIT = "unit"
        const val KEY_COMPLETED = "completed"
    }
}