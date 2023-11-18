package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView    

class Profile : ComponentActivity() {
    private var textViewUsername: TextView? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        textViewUsername = findViewById<TextView>(R.id.textview_username)

        val restaurantNavButtonProfile: AppCompatImageView = findViewById(R.id.restaurantNavButtonProfile)
        val chatNavButtonProfile: AppCompatImageView = findViewById(R.id.chatNavButtonProfile)
        val button = findViewById<View>(R.id.ChangeDetail) as ImageButton

    //    button.setOnClickListener { openDialog() }
        
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
    
    //    private fun openDialog() {
    //    val exampleDialog = ExampleDialog()
    //    exampleDialog.show(supportFragmentManager, "example dialog")
    }

    fun applyTexts(username: String?, password: String?,year:String?,hobbies:String?) {
        textViewUsername!!.text = "User name: $username\n\nMajor(s): $password\n\nYear: $year\n\nHobbies: $hobbies"
    }


    
}
