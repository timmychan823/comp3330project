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

        val createAccountButton: Button = findViewById<Button>(R.id.createAccountButton)
        val loginButton: Button = findViewById<Button>(R.id.loginButton)
        val userEmailAddress: EditText = findViewById<EditText>(R.id.user_email_address)
        val password: EditText = findViewById<EditText>(R.id.password)
        val errorText: TextView = findViewById<TextView>(R.id.error)


        createAccountButton.setOnClickListener{
            val intent = Intent(this@MainActivity, CreateaccountActivity::class.java)
            startActivity(intent)

        }

        loginButton.setOnClickListener {



            val userEmailAddressText:String = userEmailAddress!!.text.toString()
            val passwordText:String = password!!.text.toString()

            val url:String = serverIPandPort +"/login"+ "?email_address=" + userEmailAddressText+"&password="+passwordText
            val jsonObjectRequest = JsonObjectRequest( Request.Method.GET, url, null, Response.Listener {response ->
                switchActivity(response,userEmailAddressText,passwordText,errorText) },
                Response.ErrorListener { error -> Log.e("MyActivity",error.toString())
                } )
            Volley.newRequestQueue(this).add(jsonObjectRequest) }





        }

        fun switchActivity(jsonObj: JSONObject,userEmailAddressText:String,passwordText:String,errorText:TextView){

            val returned_user_id: Int =  jsonObj.get("returned_user_id") as Int

            val returned_email_address: String =  jsonObj.get("returned_email_address") as String
            val returned_password: String = jsonObj.get("returned_password") as String

            if (returned_email_address!=userEmailAddressText||returned_password!=passwordText){
                errorText.text = "Incorrect email address or incorrect password"
            }

            if ( returned_email_address==userEmailAddressText && returned_password==passwordText){
                val intent = Intent(this@MainActivity, HomePage::class.java)
                errorText.text =""
                intent.putExtra("my_user_id",returned_user_id)
                startActivity(intent)

            }




        }

}


