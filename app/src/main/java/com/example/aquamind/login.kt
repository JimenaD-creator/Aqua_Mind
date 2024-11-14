package com.example.aquamind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val iniciar_sesion = (findViewById<Button>(R.id.btn_iniciar_sesion))
        val registro = (findViewById<Button>(R.id.btn_registro))
        val email = (findViewById<EditText>(R.id.et_email))
        val pass = (findViewById<EditText>(R.id.et_password))

        iniciar_sesion.setOnClickListener {
            if(email.text.isEmpty()){
                email.error = "Favor de llenar el campo correspondiente"
            }else {
                if (pass.text.isEmpty()) {
                    pass.error = "Favor de llenar el campo correspondiente"
                } else {
                    val act1 = Intent(this, options::class.java)
                    startActivity(act1)
                }
            }
        }
        registro.setOnClickListener{
            val act2 = Intent(this, register::class.java)
            startActivity(act2)
        }

    }
}