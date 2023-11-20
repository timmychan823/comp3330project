package com.example.ricelegfinder

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FieldClassification.Match
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView

class Restaurant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val profileNavButtonRestaurant: AppCompatImageView = findViewById(R.id.profileNavButtonRestaurant)
        val chatNavButtonRestaurant: AppCompatImageView = findViewById(R.id.chatNavButtonRestaurant)
        val cymcanteen_button: AppCompatImageView = findViewById(R.id.cymcanteen_button)
        val cymcanteen_image: ImageView = findViewById(R.id.cymcanteen_image)

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
        cymcanteen_button.setOnClickListener{
            val intent = Intent(this@Restaurant, restaurant_cym::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)


        }
        cymcanteen_image.setOnClickListener{
            val intent = Intent(this@Restaurant, TimeslotActivity::class.java)
            intent.putExtra("rname","CYM Canteen")
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
        }





    }
}