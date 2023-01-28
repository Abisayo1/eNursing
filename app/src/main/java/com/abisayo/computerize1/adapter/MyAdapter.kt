package com.abisayo.computerize1.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.R
import com.abisayo.computerize1.models.Courses

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val courseList: ArrayList<Courses> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.topic_item_view,
            parent, false
        )
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = courseList[position]

        holder.courseTitle.text = currentitem.courseTitle


    }

    override fun getItemCount(): Int {

        return courseList.size
    }


    fun updateCourseList(courseList: List<Courses>) {
        this.courseList.clear()
        this.courseList.addAll(courseList)
        notifyDataSetChanged()
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val courseTitle: TextView = itemView.findViewById(R.id.question)


    }

}