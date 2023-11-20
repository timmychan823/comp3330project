package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity

class MatchActivity : ComponentActivity() {
    private var btn_rest: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match)

        val rname = intent.getStringExtra("rname").toString()

        val btn_rest: Button = findViewById<Button>(R.id.btn_rest)
        btn_rest.setOnClickListener{
            switchactivity(rname)
        }


    }
// Set a click listener for button to press the restaurant name to next activity after choosing the restaurant + switch activity


    fun switchactivity(rname: String){
        val intent = Intent(this, TimeslotActivity::class.java)
        intent.putExtra("rname",rname)
        startActivity(intent)
    }
}