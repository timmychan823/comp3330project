package com.example.ricelegfinder

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MatchmenuActivity : ComponentActivity() {

    val SERVER_IP_AND_PORT_NUMBER = "http://192.168.1.207:8888" //change this after starting the server on your laptop

    /*
    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.no, Toast.LENGTH_SHORT).show()
        finish()
        startActivity(getIntent())
    }

     */
    // Changable, depending on the current user
    val myname:String = "Leo Lam (You)"




    private var creatematch_btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.matchmenu)
        creatematch_btn = findViewById<Button>(R.id.creatematch)
        val imageBack_cymcanteen: AppCompatImageView = findViewById(R.id.imageBack_cymcanteen)
//access to the web server and display the user in the same restaurant and time slot
        val url:String = SERVER_IP_AND_PORT_NUMBER+"/matchrecord"
        val rname = intent.getStringExtra("rname").toString()
        val time = intent.getStringExtra("time").toString()
        sendMessage(url,rname!!,time!!,true)

        //Create match
        creatematch_btn!!.setOnClickListener(){
            val url = SERVER_IP_AND_PORT_NUMBER+"/matchrecord?User_Name="+myname+"&Restaurant="+rname+"&TimeSlot="+time
            Log.d("createMatchError", "This is my message"+myname+" "+rname+" "+time)
            sendMessage(url,rname!!,time!!,true)
            // showAlertDialog("You have created your own match.")

        }
        imageBack_cymcanteen.setOnClickListener{
            val intent = Intent(this@MatchmenuActivity, TimeslotActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)
        }

    }

    fun sendMessage(url: String,rname:String,time:String,mode: Boolean){
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                if(mode == true){
                    printMatchs(response,rname!!,time!!)
                }
            },
            Response.ErrorListener { error ->
                Log.d("MyActivity",error.toString())
            }
        )
        Volley.newRequestQueue(this).add(jsonObjectRequest)
    }
//display the user in the same restaurant and time slot as a clickable button
    fun printMatchs(jsonObj: JSONObject,rname: String,time: String){
        val jsonArray: JSONArray = jsonObj.get("Match") as JSONArray
        val userList = arrayListOf<String>()
        for (i in 0..jsonArray.length()-1){
            val line = jsonArray[i].toString()
            if(rname in line && time in line){
                val name: String = line.split(",")[0]
                userList.add(name.substring(2,name.length-1))
            }
        }
        val list = arrayListOf<MutableMap<String, Any>>()
        for (i in userList!!.indices) {
            val map: MutableMap<String, Any> = HashMap()
            val count = i+1
            map["Name"] = userList[i]
            list.add(map)

        }
        val adapter = SimpleAdapter(this,list, R.layout.match_list_item, arrayOf("Name"), intArrayOf(R.id.name))
        val list_view: ListView = findViewById(R.id.list_view)
        list_view.adapter = adapter



    }
// on click event of the clickable button, make a match and delete that match record from the database after clicking it
    fun select(v: View){
        Log.d("select", "clicked")
        val b = v as Button
        val url = SERVER_IP_AND_PORT_NUMBER+"/matchrecord?Delete="+b.getText().toString()
        Log.d("tag","Matched with "+b.getText().toString())
        // showAlertDialog("Matched with "+b.getText().toString())
        sendMessage(url,"","",false)
        val intent = Intent(this@MatchmenuActivity, ChatActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivityIfNeeded(intent,0)


    }
//display after making a match

    /*
    fun showAlertDialog(line:String){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("")
        dialog.setPositiveButton("OK",DialogInterface.OnClickListener(function = positiveButtonClick))
        dialog.setMessage(line)
        dialog.show()
    }
    */

}