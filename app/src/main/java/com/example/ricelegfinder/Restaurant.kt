package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView

class Restaurant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val profileNavButtonRestaurant: AppCompatImageView = findViewById(R.id.profileNavButtonRestaurant)
        val chatNavButtonRestaurant: AppCompatImageView = findViewById(R.id.chatNavButtonRestaurant)


        profileNavButtonRestaurant.setOnClickListener{
            val intent = Intent(this@Restaurant, Profile::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
            overridePendingTransition(0,0)
        }

        chatNavButtonRestaurant.setOnClickListener{
            val intent = Intent(this@Restaurant, ChatRoomActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
            overridePendingTransition(0,0)
        }





    }
}