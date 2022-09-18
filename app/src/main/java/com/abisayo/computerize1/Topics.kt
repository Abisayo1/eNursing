package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Topics : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicList: ArrayList<Topic>
    private lateinit var topicAdapter: TopicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_topics1)

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))
        topicList.add(Topic(0, "FlowChart", "Learn how to diagramize algorithms" ))


        topicAdapter = TopicAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : TopicAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0) {
                    val intent = Intent(this@Topics, Learn::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Topics, "it.exception.toString()", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }
}