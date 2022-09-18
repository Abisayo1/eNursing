package com.abisayo.computerize1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicAdapter(private val topicList:ArrayList<Topic>)
    :RecyclerView.Adapter<TopicAdapter.TopicViewHolder>(){

    private lateinit var mListner: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListner = listener
    }


    class TopicViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {


        val imageView: ImageView = itemView.findViewById(R.id.img)
        val textView: TextView = itemView.findViewById(R.id.topic)
        val detail: TextView = itemView.findViewById(R.id.detail)
        val layout: RelativeLayout = itemView.findViewById(R.id.layout)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return TopicViewHolder(view,mListner)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topicList[position]
        holder.imageView.setImageResource(topic.image)
        holder.textView.text = topic.name
        holder.detail.text = topic.details

        if (position == 1) {
            holder.layout.setBackgroundColor(Color.parseColor("#da3a3a"))
        } else if (position == 2) {
            holder.layout.setBackgroundColor(Color.parseColor("#3f88e4"))
        } else if (position == 3) {
            holder.layout.setBackgroundColor(Color.parseColor("#7678d1"))

        }
    }

    override fun getItemCount(): Int {
        return topicList.size
    }
}