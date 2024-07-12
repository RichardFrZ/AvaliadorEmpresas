package com.example.avaliadordeempresas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliadordeempresas.R
import com.example.avaliadordeempresas.adapter.viewholder.QuestionViewHolder
import com.example.avaliadordeempresas.model.QuestionModel

class QuestionListAdapter(
    private val questionList: List<QuestionModel>
) : RecyclerView.Adapter<QuestionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_question, parent, false)
        return QuestionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questionList[position]
        holder.textQuestion.text = question.textQuestion
    }
}