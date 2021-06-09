package com.example.myagent.ui.questions

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.MainActivity
import com.example.myagent.R
import com.example.myagent.adapters.QuestionsAndAnswersAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_questions_and_answers.*
import kotlinx.android.synthetic.main.fragment_questions_and_answers.view.*


class QuestionsAndAnswersFragment : Fragment() {
    lateinit var  activity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View= inflater.inflate(R.layout.fragment_questions_and_answers, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView=view.findViewById<RecyclerView>(R.id.recycler_view_question_answer_recycler)
        recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=QuestionsAndAnswersAdapter()
        view.back_arrow_faq.setOnClickListener {
            view.findNavController().navigate(R.id.action_questionsAndAnswersFragment_to_nav_all_product)
        }
        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_questionsAndAnswersFragment_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
            view.findNavController().navigate(R.id.action_questionsAndAnswersFragment_to_favouriteFragment)
        }

        back_arrow_faq.setOnClickListener {
            view.findNavController().navigate(R.id.action_questionsAndAnswersFragment_to_nav_all_product
            )
        }

    }


}