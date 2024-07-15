package com.example.avaliadordeempresas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avaliadordeempresas.R
import com.example.avaliadordeempresas.adapter.QuestionListAdapter
import com.example.avaliadordeempresas.database.DBHelper
import com.example.avaliadordeempresas.databinding.ActivityMainBinding
import com.example.avaliadordeempresas.model.QuestionModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var questionList: List<QuestionModel>
    private lateinit var adapter: QuestionListAdapter
    private lateinit var dbHelper: DBHelper
    private lateinit var result: ActivityResultLauncher<Intent>


    private var nota = -10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DBHelper(this)

        binding.recyclerViewQuestions.layoutManager = LinearLayoutManager(applicationContext)
        loadList()

        binding.buttonResult.setOnClickListener {
            val i = Intent(this, ResultActivity::class.java)
            i.putExtra("nota", nota)
            startActivity(i)
        }

        binding.buttonAddQuestion.setOnClickListener {
            result.launch(Intent(applicationContext, NewQuestionActivity::class.java))
        }

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.data!=null && it.resultCode == 1){
                loadList()
            }else if(it.data!=null && it.resultCode == 0){
                Toast.makeText(applicationContext,
                    "Operação Cancelada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadList() {
        questionList = dbHelper.getAllQuestions()
        placeAdapter()
    }

    private fun placeAdapter() {
        val itemCheckListener: (Boolean, MutableList<QuestionModel>) -> Unit = { isChecked, data ->
            if(isChecked){
                nota += 2
            }else{
                nota -= 2
            }
        }
        val questionOnClickListener: (QuestionModel) -> Unit = { question ->
            val intent = Intent(applicationContext, QuestionDetailActivity::class.java)
            intent.putExtra("id", question.id)
            result.launch(intent)
        }
        adapter = QuestionListAdapter(questionList, itemCheckListener, questionOnClickListener)
        binding.recyclerViewQuestions.adapter = adapter
    }
}