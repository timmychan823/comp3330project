package com.example.ricelegfinder
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView

class ChatRoomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)

        val profileNavButtonChat: AppCompatImageView = findViewById(R.id.profileNavButtonChat)
        val restaurantNavButtonChat: AppCompatImageView = findViewById(R.id.restaurantNavButtonChat)


        profileNavButtonChat.setOnClickListener{
            val intent = Intent(this@ChatRoomActivity, Profile::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
            overridePendingTransition(0,0)
        }

        restaurantNavButtonChat.setOnClickListener{
            val intent = Intent(this@ChatRoomActivity, Restaurant::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
            overridePendingTransition(0,0)
        }







        val studentList = ArrayList<ArrayList<String>>()

        studentList.add(arrayListOf("Charlie Chan","AMPB (year3)","Hobbies: Basketball","CYM canteen 3/10/2023 1330-1430", "3/10/2023"))
        studentList.add(arrayListOf("Philips Chan","CS/Fina (year3)","Hobbies: Football","CYM canteen 2/10/2023 1330-1430", "2/10/2023"))

        val list = arrayListOf<MutableMap<String, Any>>()
        for (i in studentList!!.indices) {
            val map: MutableMap<String, Any> = HashMap()
            val count = i+1
            map["personNameChat"] = studentList[i][0]
            map["majorAndYearChat"] = studentList[i][1]
            map["hobbiesChat"] = studentList[i][2]
            map["meetChat"] = studentList[i][3]
            map["lastMessageDateChat"] = studentList[i][4]

            list.add(map)
        }
        val adapter = SimpleAdapter(this, list, R.layout.person_list_item, arrayOf("personNameChat","majorAndYearChat","hobbiesChat","meetChat","lastMessageDateChat"), intArrayOf(R.id.personNameChat, R.id.majorAndYearChat,R.id.hobbiesChat,R.id.meetChat,R.id.lastMessageDateChat))
        val list_view:ListView = findViewById(R.id.personlist_viewChat)
        list_view.adapter = adapter

        list_view.setOnItemClickListener{parent,view,position,id->
            if (position==0){
                val intent = Intent(this@ChatRoomActivity, ChatActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivityIfNeeded(intent,0)

            }

        }


    }
}