package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val restaurantNavButtonProfile: AppCompatImageView = findViewById(R.id.restaurantNavButtonProfile)
        val chatNavButtonProfile: AppCompatImageView = findViewById(R.id.chatNavButtonProfile)


        restaurantNavButtonProfile.setOnClickListener{
            val intent = Intent(this@Profile, Restaurant::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
            overridePendingTransition(0,0)
        }

        chatNavButtonProfile.setOnClickListener{
            val intent = Intent(this@Profile, ChatRoomActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
            overridePendingTransition(0,0)
        }





    }
}