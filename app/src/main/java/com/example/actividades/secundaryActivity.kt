package com.example.actividades

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividades.databinding.ActivitySecundaryBinding

class SecundaryActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecundaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecundaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userName = intent.getStringExtra("USER_NAME") ?: "Sin nombre"
        binding.tvUserName.text = "Nombre: $userName"

        val edad = intent.getIntExtra("EDAD", 0)
        val esEstudiante = intent.getBooleanExtra("ES_ESTUDIANTE", false)
        binding.tvEdad.text = "Edad: $edad"
        binding.tvEstudiante.text = "¿Es estudiante? $esEstudiante"

        val heroe = intent.getParcelableExtra<Heroe>("HEROE")
        binding.tvHeroeNombre.text = "Héroe: ${heroe?.nombre}"
        binding.tvHeroeNivel.text = "Nivel: ${heroe?.nivel}"
        binding.tvHeroeVida.text = "Vida: ${heroe?.vida}"
    }
}