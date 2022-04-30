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

    fun getAmountCompleted(): Number? {
        return getNumber(KEY_AMOUNT_COMPLETED)
    }

    fun setAmountCompleted(amountCompleted: Number) {
        put(KEY_AMOUNT_COMPLETED, amountCompleted)
    }

    fun getCurrentStreak(): Number? {
        return getNumber(KEY_CURRENT_STREAK)
    }

    fun setCurrentStreak(currentStreak: Number) {
        put(KEY_CURRENT_STREAK, currentStreak)
    }

    fun getHighestStreak(): Number? {
        return getNumber(KEY_HIGHEST_STREAK)
    }

    fun setHighestStreak(highestStreak: Number) {
        put(KEY_HIGHEST_STREAK, highestStreak)
    }

    fun getWeeklyStatus(): BooleanArray {
        val monday = getBoolean(KEY_MONDAY)
        val tuesday = getBoolean(KEY_TUESDAY)
        val wednesday = getBoolean(KEY_WEDNESDAY)
        val thursday = getBoolean(KEY_THURSDAY)
        val friday = getBoolean(KEY_FRIDAY)
        val saturday = getBoolean(KEY_SATURDAY)
        val sunday = getBoolean(KEY_SUNDAY)
        val statusArray: BooleanArray = booleanArrayOf( monday, tuesday, wednesday, thursday, friday, saturday, sunday )
        return statusArray;
    }

    fun setWeeklyStatus(statusArray: BooleanArray) {
        put(KEY_MONDAY, statusArray[0])
        put(KEY_TUESDAY, statusArray[1])
        put(KEY_WEDNESDAY, statusArray[2])
        put(KEY_THURSDAY, statusArray[3])
        put(KEY_FRIDAY, statusArray[4])
        put(KEY_SATURDAY, statusArray[5])
        put(KEY_SUNDAY, statusArray[6])
    }

    companion object {
        const val KEY_USER = "user"
        const val KEY_HABIT_NAME = "habitName"
        const val KEY_START_DATE = "startDate"
        const val KEY_END_DATE = "endDate"
        const val KEY_COUNT = "count"
        const val KEY_TARGET = "target"
        const val KEY_UNIT = "unit"
        const val KEY_CURRENT_STREAK = "currentStreak"
        const val KEY_HIGHEST_STREAK = "highestStreak"
        const val KEY_COMPLETED = "completed"
        const val KEY_AMOUNT_COMPLETED = "amountCompleted"
        const val KEY_MONDAY = "monday"
        const val KEY_TUESDAY = "tuesday"
        const val KEY_WEDNESDAY = "wednesday"
        const val KEY_THURSDAY = "thursday"
        const val KEY_FRIDAY = "friday"
        const val KEY_SATURDAY = "saturday"
        const val KEY_SUNDAY = "sunday"
    }
}