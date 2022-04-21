package com.example.trackhab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.parse.ParseObject
import com.parse.GetCallback

import com.parse.ParseQuery




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val person = ParseObject("Person")
        person.put("name", "John Snow")
        person.put("age", 27)
        person.saveInBackground()

        val query = ParseQuery.getQuery<ParseObject>("Person")
        query.getInBackground("mhPFDlCahj") { `object`, e ->
            if (e == null) {
                // object will be your person
                Log.i("MainActivity1", "SUCCESS")
            } else {
                // something went wrong
                Log.i("MainActivity1", "FAIL: " + e)
            }
        }
    }
}