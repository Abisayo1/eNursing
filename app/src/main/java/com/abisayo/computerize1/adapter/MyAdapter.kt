package com.abisayo.computerize1.adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.NewCoursesDisplayedActivity
import com.abisayo.computerize1.R
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.models.Courses

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener
    private lateinit var currentitem : Courses

    interface onItemClickListener{
        fun onItemClicked(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    private val courseList: ArrayList<Courses> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.topic_item_view,
            parent, false
        )
        return MyViewHolder(itemView, mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        currentitem = courseList[position]

        holder.courseTitle.text = currentitem.courseTitle
        val courseTitle = currentitem.courseTitle

        val itemView = holder.itemView

        itemView.setOnClickListener {
                val intent = Intent(itemView.context, NewCoursesDisplayedActivity::class.java)
                intent.putExtra(Constants.TOPIC, courseTitle)
                itemView.context.startActivity(intent)


            }
        }





    override fun getItemCount(): Int {

        return courseList.size
    }


    fun updateCourseList(courseList: List<Courses>) {
        this.courseList.clear()
        this.courseList.addAll(courseList)
        notifyDataSetChanged()
    }


    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val courseTitle: TextView = itemView.findViewById(R.id.question)

        init {

            itemView.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }


    }

}