package com.example.avaliadordeempresas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliadordeempresas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var nota = -10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonResult.setOnClickListener {
            val i = Intent(this, ResultActivity::class.java)
            i.putExtra("nota", nota)
            startActivity(i)
        }

        binding.checkLucro20.setOnClickListener {
            if (binding.checkLucro20.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkLucro40.setOnClickListener {
            if (binding.checkLucro40.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkPrejuizo.setOnClickListener {
            if (binding.checkPrejuizo.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkCrescimentoLucro.setOnClickListener {
            if (binding.checkCrescimentoLucro.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkCrescimentoReceita.setOnClickListener {
            if (binding.checkCrescimentoReceita.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkROEAcima.setOnClickListener {
            if (binding.checkROEAcima.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkLucroAcima.setOnClickListener {
            if (binding.checkLucroAcima.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkLiquidezAcima.setOnClickListener {
            if (binding.checkLiquidezAcima.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkDividendos.setOnClickListener {
            if (binding.checkDividendos.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

        binding.checkDividaMenor.setOnClickListener {
            if (binding.checkDividaMenor.isChecked) {
                nota += 2
            } else {
                nota -= 2
            }
        }

    }
}