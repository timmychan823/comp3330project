package com.example.ricelegfinder


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ricelegfinder.ui.theme.RiceLegFinderTheme

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


import com.example.constants.serverIPandPort

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var createAccountButton: Button = findViewById(R.id.createAccountButton)
        var loginButton: Button = findViewById(R.id.loginButton)
        var userName: EditText = findViewById(R.id.userName)
        var password: EditText = findViewById(R.id.password)


        loginButton.setOnClickListener {



            val userNameText:String = userName!!.text.toString()
            val passwordText:String = password!!.text.toString()

            val url:String = serverIPandPort +"/login"+ "?email_address=" + userNameText+"&password="+passwordText
            val jsonObjectRequest = JsonObjectRequest( Request.Method.GET, url, null, Response.Listener {response ->
                switchActivity(response,userNameText,passwordText) },
                Response.ErrorListener { error -> Log.e("MyActivity",error.toString())
                } )
            Volley.newRequestQueue(this).add(jsonObjectRequest) }





        }

        fun switchActivity(jsonObj: JSONObject,userNameText:String,passwordText:String){

            val returned_email_address: String =  jsonObj.get("returned_email_address") as String
            val returned_password: String = jsonObj.get("returned_password") as String



            if ( returned_email_address==userNameText && returned_password==passwordText){
                val intent = Intent(this@MainActivity, HomePage::class.java)
                startActivity(intent)
            }




        }

}


