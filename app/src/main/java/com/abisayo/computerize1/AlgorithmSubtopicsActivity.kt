package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.databinding.ActivityAlgorithmSubtopicsBinding
import com.abisayo.computerize1.databinding.ActivityTopics1Binding

class AlgorithmSubtopicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlgorithmSubtopicsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicList: ArrayList<Topic>
    private lateinit var topicAdapter: AlgorithmsSubTopicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityAlgorithmSubtopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Algorithm", "Introduction" ))
        topicList.add(Topic(0, "Algorithm", "Types" ))
        topicList.add(Topic(0, "Algorithm", "Characteristics" ))
        topicList.add(Topic(0, "Algorithm", "Importance" ))
        topicList.add(Topic(0, "Algorithm", "Steps" ))
        topicList.add(Topic(0, "Algorithm", "Examples" ))



        topicAdapter = AlgorithmsSubTopicAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : AlgorithmsSubTopicAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0) {
                    val intent = Intent(this@AlgorithmSubtopicsActivity, AlgorithmActivity::class.java)
                    startActivity(intent)

                }

                if (position == 1) {
                    val intent = Intent(this@AlgorithmSubtopicsActivity, FlowChartElelmetsActivity::class.java)
                    startActivity(intent)

                }
                if (position == 2) {
                    val intent = Intent(this@AlgorithmSubtopicsActivity, FlowchartRulesActivity::class.java)
                    startActivity(intent)

                }
                if (position == 3) {
                    val intent = Intent(this@AlgorithmSubtopicsActivity, FlowchartAdvantagtesActivity::class.java)
                    startActivity(intent)

                }
                if (position == 4) {
                    val intent = Intent(this@AlgorithmSubtopicsActivity, FlowchartDisadvantagesActivity::class.java)
                    startActivity(intent)

                }
                if (position == 5) {
                    val intent = Intent(this@AlgorithmSubtopicsActivity, FlowchartExamplesActivity::class.java)
                    startActivity(intent)

                }
            }

        })


    }
}