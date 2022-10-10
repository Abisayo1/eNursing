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

class SubTopicsAdapter(private val topicList:ArrayList<Topic>)
    :RecyclerView.Adapter<SubTopicsAdapter.SubTopicsViewHolder>(){

    private lateinit var mListner: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListner = listener
    }


    class SubTopicsViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {


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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubTopicsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout.sub_topics_item, parent, false)
        return SubTopicsViewHolder(view,mListner)
    }

    override fun onBindViewHolder(holder: SubTopicsViewHolder, position: Int) {
        val topic = topicList[position]
        holder.imageView.setImageResource(topic.image)
        holder.textView.text = topic.name
        holder.detail.text = topic.details

        if (position == 1) {
            holder.layout.setBackgroundColor(Color.parseColor("#da3a3a"))
            holder.imageView.setImageResource(drawable.algorithm)
        } else if (position == 2) {
            holder.layout.setBackgroundColor(Color.parseColor("#3f88e4"))
        } else if (position == 3) {
            holder.layout.setBackgroundColor(Color.parseColor("#7678d1"))

        } else{
            holder.imageView.setImageResource(drawable.flowchart)
        }
    }

    override fun getItemCount(): Int {
        return topicList.size
    }
}