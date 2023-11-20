package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout

class restaurant_cym : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_cym)

        val imageback_cymcanteen: AppCompatImageView = findViewById(R.id.imageBack_cymcanteen)
        val imageView: ImageView = findViewById(R.id.imageView)
        val enlargedView: ImageView = findViewById(R.id.enlarged_imageView)
        val wholeLayout: ConstraintLayout = findViewById(R.id.wholeLayout)

        imageback_cymcanteen.setOnClickListener{

                val intent = Intent(this@restaurant_cym, Restaurant::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivityIfNeeded(intent,0)
            }
        imageView.setOnClickListener{
            imageView.visibility = View.GONE
            enlargedView.visibility = View.VISIBLE
            wholeLayout.alpha = 0.5F

        }
        enlargedView.setOnClickListener{
            imageView.visibility = View.VISIBLE
            enlargedView.visibility = View.GONE
            wholeLayout.alpha = 1F
        }

        }



}
