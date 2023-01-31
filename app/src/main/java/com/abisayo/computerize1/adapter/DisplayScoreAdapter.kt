package com.abisayo.computerize1.adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.NewCoursesDisplayedActivity
import com.abisayo.computerize1.R
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.models.Scores


class DisplayScoreAdapter : RecyclerView.Adapter<DisplayScoreAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener
    private lateinit var currentitem : Scores

    interface onItemClickListener{
        fun onItemClicked(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    private val scoreList: ArrayList<Scores> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.display_score_item,
            parent, false
        )
        return MyViewHolder(itemView, mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        currentitem = scoreList[position]

        holder.courseTopic.text = currentitem.courseTitle
        holder.studentName.text = currentitem.studentName
        holder.studentScore.text = currentitem.studentScore

        val courseTitle = currentitem.courseTitle

        val itemView = holder.itemView

    }





    override fun getItemCount(): Int {

        return scoreList.size
    }


    fun updatescoreList(scoreList: List<Scores>) {
        this.scoreList.clear()
        this.scoreList.addAll(scoreList)
        notifyDataSetChanged()
    }


    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val courseTopic: TextView = itemView.findViewById(R.id.topic)
        val studentName: TextView = itemView.findViewById(R.id.student_name)
        val studentScore: TextView = itemView.findViewById(R.id.student_score)

        init {

            itemView.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }


    }

}