package com.example.myagent.ui.auth

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import com.example.myagent.MainActivity
import com.example.myagent.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_my_profile.*
import kotlinx.android.synthetic.main.fragment_my_profile.view.*

class MyProfileFragment : Fragment() {

    val CAMERA_REQUEST = 123
    lateinit var  activity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View=inflater.inflate(R.layout.fragment_my_profile, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.imageBackHome_my_profil.setOnClickListener {
            view.findNavController().navigate(R.id.action_nav_my_profile_to_nav_all_product)
        }

        activity=requireActivity() as MainActivity

        activity.imageBasket.setOnClickListener {
            Log.d("ttt", "imageBasket")

            view.findNavController().navigate(R.id.action_nav_my_profile_to_nav_basket)
        }

        activity.imageStar.setOnClickListener {
            Log.d("ttt", "imageStar")
//            navController.popBackStack()
            view.findNavController().navigate(R.id.action_nav_my_profile_to_favouriteFragment)
        }


        btn.setOnClickListener {

            val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,
                CAMERA_REQUEST);

            startActivityForResult(intent,CAMERA_REQUEST)
        }
        view.button_save_changes.setOnClickListener {
            view.findNavController().navigate(R.id.nav_all_product)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            val photo: Bitmap = data!!.extras!!.get("data") as Bitmap

            imageView.setBackgroundResource(R.drawable.rounded_login);
            imageView.setImageBitmap(photo)
        }
    }
}