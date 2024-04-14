package com.example.avaliadordeempresas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.avaliadordeempresas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var nota = -10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkLucro20.setOnClickListener {
            if(binding.checkLucro20.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkLucro40.setOnClickListener {
            if(binding.checkLucro40.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkPrejuizo.setOnClickListener {
            if(binding.checkPrejuizo.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkCrescimentoLucro.setOnClickListener {
            if(binding.checkCrescimentoLucro.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkCrescimentoReceita.setOnClickListener {
            if(binding.checkCrescimentoReceita.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkROEAcima.setOnClickListener {
            if(binding.checkROEAcima.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkLucroAcima.setOnClickListener {
            if(binding.checkLucroAcima.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkLiquidezAcima.setOnClickListener {
            if(binding.checkLiquidezAcima.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkDividendos.setOnClickListener {
            if(binding.checkDividendos.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }

        binding.checkDividaMenor.setOnClickListener {
            if(binding.checkDividaMenor.isChecked()){
                nota += 2
                binding.textNota.setText("Nota: $nota")
            }else{
                nota -= 2
                binding.textNota.setText("Nota: $nota")
            }
        }



    }
}