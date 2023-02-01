package com.abisayo.computerize1.Flowcharts

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.Algorithms.AlgorithmExampleActivity
import com.abisayo.computerize1.databinding.ActivityTrendSubTopicBinding
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.data.startFlowChartActivity

class FlowchartsSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrendSubTopicBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicList: ArrayList<Topic>
    private lateinit var topicAdapter: FlowchartSubtopicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityTrendSubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Flowcharts", "Introduction"))
        topicList.add(Topic(0, "Flowcharts", "Elements"))
        topicList.add(Topic(0, "Flowcharts", "Guidelines"))
        topicList.add(Topic(0, "Flowcharts", "Advantages"))
        topicList.add(Topic(0, "Flowcharts", "Disadvantages"))
        topicList.add(Topic(0, "Flowcharts", "Examples"))

        topicAdapter = FlowchartSubtopicAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : FlowchartSubtopicAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@FlowchartsSubTopicActivity.startFlowChartActivity(Flashcards.trendIntroFlashcard(), 0)
                    }
                    1 -> {
                        val intent = Intent(this@FlowchartsSubTopicActivity, FlowchartElementsActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        this@FlowchartsSubTopicActivity.startFlowChartActivity(Flashcards.trendSpecializationFlashcard(), 1)
                    }
                    3 -> {
                        this@FlowchartsSubTopicActivity.startFlowChartActivity(Flashcards.trendOutpatientFlashcard(), 2)
                    }
                    4 -> {
                        this@FlowchartsSubTopicActivity.startFlowChartActivity(Flashcards.trendNavigatorFlashcard(), 3)
                    }
                    5 -> {
                        val intent = Intent(this@FlowchartsSubTopicActivity, FlowchartExampleActivity::class.java)
                        startActivity(intent)
                    }

                }
            }
        })

    }
}