package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView

class restaurant_cym : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_cym)

        val imageback_cymcanteen: AppCompatImageView = findViewById(R.id.imageBack_cymcanteen)

        imageback_cymcanteen.setOnClickListener{

                val intent = Intent(this@restaurant_cym, Restaurant::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivityIfNeeded(intent,0)
            }
        }

}
