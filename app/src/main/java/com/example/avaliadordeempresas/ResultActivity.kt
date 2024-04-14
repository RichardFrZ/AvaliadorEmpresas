package com.example.avaliadordeempresas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import com.example.avaliadordeempresas.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val nota = i.getIntExtra("nota", 0)

        val resultado = "Nota final da empresa: \n" +
                "${nota}"

        binding.textResult.setText(resultado)

    }
}