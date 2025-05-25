package com.example.etimpamigustavoportelapreferenciasdecores

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.etimpamigustavoportelapreferenciasdecores.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val NOME_ARQUIVO = "minhas_preferencias"

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


    override fun onResume() {
        super.onResume()
        val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val cor = preferencias.getString("cor", "")
        if (cor!!.isNotEmpty()) {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

    }


    private fun salvarCor(cor: String) {
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        binding.btnTrocar.setOnClickListener { view ->
            val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.putString("nome", "Gustavo")
            editor.putString("sobrenome", "Portela")
            editor.putInt("idade", 90)
            editor.apply()

            snackBar(view)
        }

    }

    private fun snackBar(view: View) {
        val snackbar =
            Snackbar.make(view, "cor de fundo alterada com sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK") {

        }
        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()


    }


}
