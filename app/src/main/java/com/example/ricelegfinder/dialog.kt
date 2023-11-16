package com.example.ricelegfinder

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment

class ExampleDialog : AppCompatDialogFragment() {
    private var listener: ExampleDialogListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.prompts, null)

        val editTextUsername = view.findViewById<EditText>(R.id.edit_username)
        val editTextMajor = view.findViewById<EditText>(R.id.edit_major)
        val editTextYear = view.findViewById<EditText>(R.id.edit_year)
        val editTextHobbies = view.findViewById<EditText>(R.id.edit_Hobbies)

        return AlertDialog.Builder(requireActivity())
            .setView(view)
            .setTitle("UserInfo")
            .setNegativeButton("Cancel") {_, _, ->}
            .setPositiveButton("Ok") {_, _, ->
                val username = editTextUsername.text.toString()
                val major = editTextMajor.text.toString()
                val year = editTextYear.text.toString()
                val hobbies = editTextHobbies.text.toString()
                listener!!.applyTexts(username, major,year,hobbies)
            }
            .create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as ExampleDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement ExampleDialogListener"
            )
        }
    }



    interface ExampleDialogListener {
        fun applyTexts(username: String?, major: String?,year:String?,hobbies:String?)
    }
}
