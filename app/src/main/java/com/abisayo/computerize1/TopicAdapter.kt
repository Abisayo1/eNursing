package com.abisayo.computerize1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.R.*

class TopicAdapter(private val topicList: ArrayList<Topic>) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    private lateinit var mListner: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListner = listener
    }


    class TopicViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {


        val imageView: ImageView = itemView.findViewById(id.img)
        val textView: TextView = itemView.findViewById(id.question)
        val detail: TextView = itemView.findViewById(id.detail)
        val layout: RelativeLayout = itemView.findViewById(id.layout)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.topic_item_view, parent, false)
        return TopicViewHolder(view, mListner)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topicList[position]
        holder.imageView.setImageResource(topic.image)
        holder.textView.text = topic.name
        holder.detail.text = topic.details

        holder.imageView.setImageResource(drawable.history_of_nursing)
        when (position) {
            0, 6, 12, 18 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#da3a3a"))
            }
            1, 7, 13, 19 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#6CD0FF"))
            }
            2, 8, 14, 20 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#801155"))
            }
            3, 9, 15, 21 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#9A6AFF"))
            }
            4, 10, 16, 22 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#1E2029"))
            }
            5, 11, 17, 23 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#E86926"))
            }
        }
    }

    override fun getItemCount(): Int {
        return topicList.size
    }
}