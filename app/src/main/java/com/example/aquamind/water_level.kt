package com.example.aquamind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView

class water_level : AppCompatActivity() {

    private lateinit var levelTextView: TextView
    private lateinit var volumeTextView: TextView
    private lateinit var tankImageView: ImageView

    private var litrosRestantes = 1000 // Capacidad total del tanque
    private var litrosConsumidos = 0
    private val handler = Handler(Looper.getMainLooper()) // Cambia aquí
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_level)
        levelTextView = findViewById(R.id.tv_level)
        volumeTextView = findViewById(R.id.tv_volume)
        tankImageView = findViewById(R.id.iv_emptytank) // Asegúrate de tener un ImageView para el tanque

        // Iniciar la simulación del nivel de agua
        simularNivelAgua()
    }
    private fun simularNivelAgua() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (litrosRestantes > 0) {
                    litrosRestantes -= 10 // Simula un consumo
                    litrosConsumidos += 10

                    // Actualiza los textos en la interfaz
                    levelTextView.text = "Litros restantes: $litrosRestantes"
                    volumeTextView.text = "Litros consumidos: $litrosConsumidos"

                    // Actualiza la imagen del tanque según el nivel de agua
                    actualizarImagenTanque()

                    // Llama a la función de nuevo para seguir la simulación
                    simularNivelAgua()
                }
            }
        }, 1000) // Cambia el nivel cada segundo
    }

    private fun actualizarImagenTanque() {
        // Cambia la imagen del tanque según el nivel de agua
        when {
            litrosRestantes > 1000 -> tankImageView.setImageResource(R.drawable.tank12) // Imagen tanque alto
            litrosRestantes > 950 -> tankImageView.setImageResource(R.drawable.tank11)
            litrosRestantes > 900 -> tankImageView.setImageResource(R.drawable.tank10)
            litrosRestantes > 800 -> tankImageView.setImageResource(R.drawable.tank9)
            litrosRestantes > 700 -> tankImageView.setImageResource(R.drawable.tank8)
            litrosRestantes > 600 -> tankImageView.setImageResource(R.drawable.tank7)
            litrosRestantes > 500 -> tankImageView.setImageResource(R.drawable.tank6) // Imagen tanque medio
            litrosRestantes > 200 -> tankImageView.setImageResource(R.drawable.tank2) // Imagen tanque bajo
            litrosRestantes > 100 -> tankImageView.setImageResource(R.drawable.tank1)
            else -> tankImageView.setImageResource(R.drawable.pngegg) // Imagen tanque vacío
        }
    }
}