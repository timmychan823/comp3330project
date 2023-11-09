package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView

class ChatActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val imageBack: AppCompatImageView = findViewById(R.id.imageBack)
        val inputMessage: EditText = findViewById(R.id.inputMessage)
        val ic_send: AppCompatImageView = findViewById(R.id.sendButton)

        imageBack.setOnClickListener{
            val intent = Intent(this@ChatActivity, MainActivity::class.java)
            startActivity(intent)
        }

        ic_send.setOnClickListener{
            inputMessage.setText("")
        }


    }

}