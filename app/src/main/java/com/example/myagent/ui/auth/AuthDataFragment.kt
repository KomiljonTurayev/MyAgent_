package com.example.myagent.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myagent.R
import kotlinx.android.synthetic.main.fragment_auth_data.view.*

class AuthDataFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_auth_data, container, false)
        view.back_login.setOnClickListener{
            view.findNavController().popBackStack()
        }
        view.button_login.setOnClickListener {
            view.findNavController().popBackStack()
            view.findNavController().navigate(R.id.nav_all_product)
        }
        return view
    }


}