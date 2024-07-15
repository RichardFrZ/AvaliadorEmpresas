package com.example.avaliadordeempresas.adapter.listener

import android.view.View.OnClickListener
import com.example.avaliadordeempresas.model.QuestionModel

class QuestionOnClickListener(val clickListener: (question: QuestionModel) -> Unit) {
    fun onClick(question: QuestionModel) = clickListener
}