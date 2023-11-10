package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView

class PassCode : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_code)

        val image_back_passcode: AppCompatImageView = findViewById(R.id.imageBackPasscode)

        image_back_passcode.setOnClickListener{
            val intent = Intent(this@PassCode, MainActivity::class.java)
            startActivity(intent)

        }




    }
}