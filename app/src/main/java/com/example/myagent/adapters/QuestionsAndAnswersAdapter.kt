package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.item_questions_and_answers.view.*

class QuestionsAndAnswersAdapter:RecyclerView.Adapter<QuestionsAndAnswersAdapter.ItemView>() {
    val list=MockData.getQuestionAnswer()
    inner class ItemView(view: View):RecyclerView.ViewHolder(view){
        val title=view.question_answer_title
        val img=view.arrow_icon_image
        val body=view.question_answer_body
        fun bind(d: MockData.QuestionAnswerData){
            title.text=d.title
            body.text=d.body
            body.visibility=View.GONE
        }
        init {
            var i=1
            view.arrow_icon_image.setOnClickListener {
                if (i==1){
                    body.visibility=View.VISIBLE
                    img.setImageResource(R.drawable.ic_arrow_ios_up)
                    i=2
                }
                else{
                   body.visibility=View.GONE
                    img.setImageResource(R.drawable.ic_arrow_ios_down)
                    i=1
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.item_questions_and_answers,parent,false)
        return ItemView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        return holder.bind(list[position])
    }
}