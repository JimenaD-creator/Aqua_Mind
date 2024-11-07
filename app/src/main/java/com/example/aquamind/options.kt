package com.example.aquamind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class options : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_options)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var levels = (findViewById<Button>(R.id.btn_level))
        var calendar = (findViewById<Button>(R.id.btn_calendar))

        levels.setOnClickListener {
            val act1 = Intent(this, water_level::class.java)
            startActivity(act1)

        }
        calendar.setOnClickListener{
            val act2 = Intent(this, calendar::class.java)
            startActivity(act2)

        }
    }
}