package com.example.ricelegfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.constants.serverIPandPort
import org.json.JSONObject

class CreateaccountActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.createaccount)

        val create_email_address: EditText = findViewById<EditText>(R.id.create_email_address)
        val create_password: EditText = findViewById<EditText>(R.id.create_password)
        val create_account_button: Button = findViewById(R.id.create_account_button)

        create_account_button.setOnClickListener {



            val createEmailAddressText:String = create_email_address!!.text.toString()
            val createPasswordText:String = create_password!!.text.toString()

            val url:String = serverIPandPort +"/passcode"+ "?email_address=" + createEmailAddressText
            val jsonObjectRequest = JsonObjectRequest( Request.Method.GET, url, null, Response.Listener { response ->
                dummy(response,createEmailAddressText) },
                Response.ErrorListener { error -> Log.e("MyActivity",error.toString())
                } )
            Volley.newRequestQueue(this).add(jsonObjectRequest)
        }







    }

    fun dummy(jsonObj: JSONObject, createEmailAddressText: String) {

    }
}