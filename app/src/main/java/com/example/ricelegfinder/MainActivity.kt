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


        createAccountButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateaccountActivity::class.java)
            startActivity(intent)

        }

        loginButton.setOnClickListener {


            val userEmailAddressText: String = userEmailAddress!!.text.toString()
            val passwordText: String = password!!.text.toString()

            if (userEmailAddressText != "ricelegfinder@connect.hku.hk" || passwordText != "123456") {
                errorText.text = "Incorrect email address or password"
            } else {
                val intent = Intent(this@MainActivity, HomePage::class.java)
                errorText.text =""
                intent.putExtra("my_user_id",1)
                startActivity(intent)

            }


        }
    }



}


