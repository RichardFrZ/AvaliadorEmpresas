package com.example.avaliadordeempresas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.avaliadordeempresas.R
import com.example.avaliadordeempresas.database.DBHelper
import com.example.avaliadordeempresas.databinding.ActivityNewQuestionBinding
import com.example.avaliadordeempresas.databinding.ActivityResultBinding

class NewQuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelper(applicationContext)
        val i = intent

        binding.buttonAdd.setOnClickListener {
            val question = binding.editQuestion.text.toString()

            if (question.isNotEmpty()) {
                val res = db.insertQuestion(question)
                if (res > 0) {
                    Toast.makeText(
                        applicationContext,
                        "Inserido com Sucesso", Toast.LENGTH_SHORT
                    ).show()
                    setResult(1, i)
                    finish()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Erro na inserção", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.buttonCancel.setOnClickListener {
            setResult(0,i)
            finish()
        }

    }
}