package com.example.avaliadordeempresas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.avaliadordeempresas.R
import com.example.avaliadordeempresas.database.DBHelper
import com.example.avaliadordeempresas.databinding.ActivityQuestionDetailBinding
import com.example.avaliadordeempresas.model.QuestionModel

class QuestionDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionDetailBinding
    private lateinit var db: DBHelper
    private var questionModel = QuestionModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val i = intent
        val id = i.extras?.getInt("id")
        db = DBHelper(applicationContext)

        if (id != null) {
            questionModel = db.getQuestion(id)
            populate()
        } else {
            finish()
        }

        binding.buttonEdit.setOnClickListener {
            binding.layoutEdit.visibility = View.GONE
            binding.layoutEditDelete.visibility = View.VISIBLE
            changeEditText(true)
        }

        binding.buttonBack.setOnClickListener {
            setResult(0, i)
            finish()
        }

        binding.buttonEditSave.setOnClickListener {
            val res = db.updateQuestion(
                id = questionModel.id, question = binding.editQuestion.text.toString()
            )
            if (res > 0) {
                Toast.makeText(
                    applicationContext, "Editado com Sucesso", Toast.LENGTH_SHORT
                ).show()
                setResult(1, i)
                finish()
            } else {
                Toast.makeText(
                    applicationContext, "Erro na Edição", Toast.LENGTH_SHORT
                ).show()
                setResult(0, i)
                finish()
            }
        }

        binding.buttonEditCancel.setOnClickListener {
            binding.layoutEdit.visibility = View.VISIBLE
            binding.layoutEditDelete.visibility = View.GONE
            populate()
            changeEditText(false)
        }

        binding.buttonEditDelete.setOnClickListener {
            val res = db.deleteQuestion(questionModel.id)

            if (res > 0) {
                Toast.makeText(
                    applicationContext, "Removido com Sucesso", Toast.LENGTH_SHORT
                ).show()
                setResult(1, i)
                finish()
            } else {
                Toast.makeText(
                    applicationContext, "Erro na Remoção", Toast.LENGTH_SHORT
                ).show()
                setResult(0, i)
                finish()
            }
        }

    }

    private fun changeEditText(status: Boolean) {
        binding.editQuestion.isEnabled = status
    }

    private fun populate() {
        binding.editQuestion.setText(questionModel.textQuestion)
    }
}