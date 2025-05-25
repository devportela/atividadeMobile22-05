package com.example.etimpamigustavoportelapreferenciasdecores

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.etimpamigustavoportelapreferenciasdecores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cor = ""

        binding.btnCor1.setOnClickListener {
            cor = "#C20EE4"
            salvarCor(cor)
        }

        binding.btnCor2.setOnClickListener {
            cor = "#FFEB3B"
            salvarCor(cor)
        }

        binding.btnCor3.setOnClickListener {
            cor = "#FF5722"
            salvarCor(cor)
        }

        binding.btnCor4.setOnClickListener {
            cor = "#03A9F4"
            salvarCor(cor)
        }

        binding.btnCor5.setOnClickListener {
            cor = "#BC6F06"
            salvarCor(cor)
        }
    }

    private fun salvarCor(cor: String) {
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
    }
}
