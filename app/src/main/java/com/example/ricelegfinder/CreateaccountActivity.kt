package com.example.ricelegfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.compose.foundation.layout.Box
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class CreateaccountActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.createaccount)

        val create_email_address: EditText = findViewById<EditText>(R.id.create_email_address)
        val create_password: EditText = findViewById<EditText>(R.id.create_password)
        val create_account_button: Button = findViewById(R.id.create_account_button)
        val create_account_error_text: TextView = findViewById(R.id.create_account_error)
        val create_display_name: EditText = findViewById<EditText>(R.id.create_display_name)
        val image_back_create: AppCompatImageView = findViewById(R.id.imageBackCreate)

        create_account_button.setOnClickListener {

            val createEmailAddressText:String = create_email_address!!.text.toString()
            val createPasswordText:String = create_password!!.text.toString()
            val createDisplayNameText:String = create_display_name!!.text.toString()


            val substring = ".+@connect.hku.hk$"
            val regex = substring.toRegex()

            if (regex.containsMatchIn(createEmailAddressText)){
                create_account_error_text.text=""
                val intent = Intent(this@CreateaccountActivity, PassCode::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivityIfNeeded(intent,0)

            }else{
                create_account_error_text.text="Not HKU email account"
            }

        }
        image_back_create.setOnClickListener{
            val intent = Intent(this@CreateaccountActivity, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivityIfNeeded(intent,0)

        }







    }

    fun dummy(jsonObj: JSONObject, createEmailAddressText: String) {

    }
}