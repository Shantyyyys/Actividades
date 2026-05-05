package com.example.actividades

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividades.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEnviar.setOnClickListener {
            val userName = binding.txtName.text.toString()

            val bundle = Bundle()
            bundle.putInt("EDAD", 22)
            bundle.putBoolean("ES_ESTUDIANTE", true)

            val heroe = Heroe(nombre = "Link", nivel = 5, vida = 100)

            val intent = Intent(this, SecundaryActivity::class.java)
            intent.putExtra("USER_NAME", userName)
            intent.putExtras(bundle)
            intent.putExtra("HEROE", heroe)

            startActivity(intent)
        }
    }
}