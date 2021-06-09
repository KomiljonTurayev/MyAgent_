package com.example.myagent.ui.communication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myagent.MainActivity
import com.example.myagent.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_questions_answers.view.*

class QuestionsAnswersFragment : Fragment() {
    lateinit var  activity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_answers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.imageBackHome_question.setOnClickListener {
            view.findNavController().navigate(R.id.action_nav_questions_answers_to_nav_all_product)
        }




        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_nav_questions_answers_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
            view.findNavController().navigate(R.id.action_nav_questions_answers_to_favouriteFragment)
        }
    }

}