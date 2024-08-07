package com.example.avaliadordeempresas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliadordeempresas.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        var nota = i.getIntExtra("nota", 0)

        val resultado = "Nota da empresa: \n" +
                "${nota}"

        binding.textResult.setText(resultado)

        binding.buttonVoltar.setOnClickListener {
            nota = 0
            finish()
        }
    }
}