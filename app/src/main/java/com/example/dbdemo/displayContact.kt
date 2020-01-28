package com.example.dbdemo

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class displayContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_contact)


        val intent = intent
        val id = intent.getStringExtra("Rid")
        val name = intent.getStringExtra("Rname")
        val phone = intent.getStringExtra("Rphone")

        val idTextView = findViewById<TextView>(R.id.displayId)
        idTextView.text = id


        val nameTextView = findViewById<TextView>(R.id.displayName)
        nameTextView.text = name

        val phoneTextView = findViewById<TextView>(R.id.displayPhone)
        phoneTextView.text = phone

    }
}
