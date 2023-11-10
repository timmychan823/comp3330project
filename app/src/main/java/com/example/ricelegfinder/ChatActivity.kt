package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val imageBack: AppCompatImageView = findViewById(R.id.imageBack)
        val inputMessage: EditText = findViewById(R.id.inputMessage)
        val ic_send: AppCompatImageView = findViewById(R.id.sendButton)
        val recyclerView: RecyclerView = findViewById(R.id.chatRecyclerView)

        val items:ArrayList<Item> = arrayListOf()
        items.add( Item("Hello","Received"))

        recyclerView.adapter =  MyAdapter(applicationContext,items)



        imageBack.setOnClickListener{
            val intent = Intent(this@ChatActivity, MainActivity::class.java)
            startActivity(intent)
        }

        ic_send.setOnClickListener{
            items.add(Item(inputMessage!!.text.toString(),"Sent"))

            recyclerView.adapter =  MyAdapter(applicationContext,items)
            inputMessage.setText("")

        }


    }

}