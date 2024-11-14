package com.example.aquamind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var name = (findViewById<EditText>(R.id.et_name))
        var email = (findViewById<EditText>(R.id.et_email2))
        var password = (findViewById<EditText>(R.id.et_password2))
        var register = (findViewById<Button>(R.id.btn_register))

        register.setOnClickListener {
            if(name.text.isEmpty()){
                name.error = "Favor de llenar el campo correspondiente"
            }else{
                if(email.text.isEmpty()){
                    email.error = "Favor de llenar el campo correspondiente"
                }else {
                    if (password.text.isEmpty()) {
                        password.error = "Favor de lenar el campo correspondiente"
                    } else {
                        val act3 = Intent(this, options::class.java)
                        startActivity(act3)

                    }
                }
            }
        }
    }
}