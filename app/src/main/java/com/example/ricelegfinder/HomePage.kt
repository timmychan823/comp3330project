package com.example.ricelegfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.constants.serverIPandPort


class HomePage : ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val testing: TextView = findViewById<TextView>(R.id.my_user_id)

        val bundle: Bundle? = intent.extras
        bundle?.let{
            bundle.apply{
                val my_user_id: Int? = getInt("my_user_id")
                testing.text = my_user_id.toString()



            }
        }
    }
}