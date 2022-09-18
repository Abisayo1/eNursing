package com.abisayo.computerize1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicAdapter(private val topicList:ArrayList<Topic>) {

    class TopicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.img)
        val textView: TextView = itemView.findViewById(R.id.topic)
        val detail: TextView = itemView.findViewById(R.id.detail)
    }
}