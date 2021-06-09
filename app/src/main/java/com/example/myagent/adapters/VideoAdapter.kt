package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.item_how_does_it_work.view.*


class VideoAdapter:RecyclerView.Adapter<VideoAdapter.ItemView>() {
    val list=MockData.getHowDoesItWork()


    inner class ItemView(view:View): RecyclerView.ViewHolder(view){

        //val video: WebView=view.video_view


        val text=view.text_of_video



        fun bind(d: MockData.HowDoesItWorkData){

          //  youTubePlayer.initialize("AIzaSyA7gDntTbbYJ80qD-Av0hbFXkRuk2ZBBqo",YouTubePlayer.Provider { s, onInitializedListener ->  })
           // video.("https://www.youtube.com/watch?v=qz7JaDZp_2w")




            text.text=d.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.item_how_does_it_work,parent,false)
        return ItemView(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        return holder.bind(list[position])
    }
}