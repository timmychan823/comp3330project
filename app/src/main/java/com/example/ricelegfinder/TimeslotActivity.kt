package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity

class TimeslotActivity : ComponentActivity() {
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timeslot)
        val rname = intent.getStringExtra("rname").toString()
        button1 = findViewById<Button>(R.id.button1)
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)
        button4 = findViewById<Button>(R.id.button4)
        setlistener(button1!!,rname)
        setlistener(button2!!,rname)
        setlistener(button3!!,rname)
        setlistener(button4!!,rname)

    }
// set on click listener to pass the selected timeslot and restaurant to next activity + switch activity
    fun setlistener(b: Button,rname: String){
        b.setOnClickListener() {
            val temp = b.getText().toString()
            val time = temp.subSequence(0, 5).toString()
            switchactivity(rname, time)
        }
    }

    fun switchactivity(rname: String, time: String){
        val intent = Intent(this, MatchmenuActivity::class.java)
        intent.putExtra("rname",rname)
        intent.putExtra("time",time)
        startActivity(intent)
    }

}