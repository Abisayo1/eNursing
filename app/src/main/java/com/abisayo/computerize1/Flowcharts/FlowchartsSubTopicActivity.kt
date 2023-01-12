package com.abisayo.computerize1.Flowcharts

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.databinding.ActivityTrendSubTopicBinding
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.data.startTrendsFlashcardActivity

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
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendIntroFlashcard())
                    }
                    1 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendTeleHealthFlashcard())
                    }
                    2 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendSpecializationFlashcard())
                    }
                    3 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendOutpatientFlashcard())
                    }
                    4 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendNavigatorFlashcard())
                    }
                    5 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendENTFlashcard())
                    }
                    6 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendDoctoralFlashcard())
                    }
                    7 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendEduOnlineFlashcard())
                    }
                    8 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendShortageFlashcard())
                    }
                    9 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendAdvocacyFlashcard())
                    }
                    10 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendSelfCareFlashcard())
                    }
                    11 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendSalariesFlashcard())
                    }
                    12 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendBiLingualFlashcard())
                    }
                    13 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendMalesFlashcard())
                    }
                    14 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendHolisticFlashcard())
                    }
                    15 -> {
                        this@FlowchartsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendPatientsFlashcard())
                    }
                }
            }
        })

    }
}