package com.example.avaliadordeempresas.adapter.viewholder

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliadordeempresas.R

class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textQuestion: TextView = view.findViewById(R.id.id_question)
    val checkValue: CheckBox =  itemView.findViewById(R.id.check_question)
}