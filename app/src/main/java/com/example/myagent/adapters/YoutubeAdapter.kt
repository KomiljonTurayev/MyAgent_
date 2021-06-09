package com.example.myagent.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.myagent.R
import com.example.myagent.network.dto.MockData
import kotlinx.android.synthetic.main.video_per_row.view.*

class YoutubeAdapter() : RecyclerView.Adapter<YoutubeAdapter.YoutubeViewHolder>() {
    val data = MockData.getDataSetListList()

    class YoutubeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var webView: WebView = itemView.findViewById(R.id.video_view)
        var button: Button = itemView.findViewById(R.id.fullscreen)
        var text=itemView.youtube_video_text

        init {
            webView.webViewClient = WebViewClient()
            webView.webChromeClient = WebChromeClient()
            webView.settings.javaScriptEnabled = true
        }

        fun bind(item: MockData.DataSetList) {

            itemView.apply {
                val d = item

                webView.loadUrl(d.link!!)
//                button.setOnClickListener {
//            val i = Intent(context, VideoFullScreen::class.java)
//            i.putExtra("link", current.link)
//            context.startActivity(i)
                }
            text.text=item.text
            }


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YoutubeViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.video_per_row, parent, false)
            return YoutubeViewHolder(view)
        }

        override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) =
            holder.bind(data[position])

        override fun getItemCount() = data.size

//    class YoutubeViewHolder @SuppressLint("SetJavaScriptEnabled") constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var webView: WebView
//        var button: Button
//
//        init {
//            webView = itemView.findViewById(R.id.video_view)
//            button = itemView.findViewById(R.id.fullscreen)
//            webView.webViewClient = WebViewClient()
//            webView.webChromeClient = WebChromeClient()
//            webView.settings.javaScriptEnabled = true
//        }
//    }
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): YoutubeViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.video_per_row, viewGroup, false)
//        return YoutubeViewHolder(view)
//    }
//
//    override fun onBindViewHolder(youtubeViewHolder: YoutubeViewHolder, i: Int) {
//        val current = arrayList[i]
//        youtubeViewHolder.webView.loadUrl(current.link!!)
//        youtubeViewHolder.button.setOnClickListener {
//            val i = Intent(context, VideoFullScreen::class.java)
//            i.putExtra("link", current.link)
//            context.startActivity(i)
//        }
//    }
//
//    init {
//        this.arrayList = arrayList
//        this.context = context!!
//    }
    }