package com.abisayo.computerize1.trendsInNursing

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

class TrendsSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrendSubTopicBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicList: ArrayList<Topic>
    private lateinit var topicAdapter: SubTopicsAdapter

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

        topicList.add(Topic(0, "Trends in Nursing", "Introduction"))
        topicList.add(Topic(0, "Trends in Nursing", "Continued Growth of Telehealth and Privacy Concerns"))
        topicList.add(Topic(0, "Trends in Nursing", "Increased Specialization"))
        topicList.add(Topic(0, "Trends in Nursing", "Nurses Moving Into the Community Outpatient Setting"))
        topicList.add(Topic(0, "Trends in Nursing", "Rise of the Nurse Navigator"))
        topicList.add(Topic(0, "Trends in Nursing", "Expanding Entrepreneurship Opportunities"))
        topicList.add(Topic(0, "Trends in Nursing", "Increasing Need for Doctoral Education"))
        topicList.add(Topic(0, "Trends in Nursing", "Furthering Nursing Education Online"))
        topicList.add(Topic(0, "Trends in Nursing", "Impact of the Looming Nursing Shortage"))
        topicList.add(Topic(0, "Trends in Nursing", "Nurses Getting Involved Through Advocacy and Action"))
        topicList.add(Topic(0, "Trends in Nursing", "Implementing Self-Care in Nursing"))
        topicList.add(Topic(0, "Trends in Nursing", "Increase in Salaries and Benefits"))
        topicList.add(Topic(0, "Trends in Nursing", "Bilingual nurses will be more valued in more demand"))
        topicList.add(Topic(0, "Trends in Nursing", "Males entering the nurse workforce will rise"))
        topicList.add(Topic(0, "Trends in Nursing", "Holistic Care will become more popular"))
        topicList.add(Topic(0, "Trends in Nursing", "Patients are becoming more educated"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendIntroFlashcard())
                    }
                    1 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendTeleHealthFlashcard())
                    }
                    2 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendSpecializationFlashcard())
                    }
                    3 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendOutpatientFlashcard())
                    }
                    4 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendNavigatorFlashcard())
                    }
                    5 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendENTFlashcard())
                    }
                    6 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendDoctoralFlashcard())
                    }
                    7 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendEduOnlineFlashcard())
                    }
                    8 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendShortageFlashcard())
                    }
                    9 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendAdvocacyFlashcard())
                    }
                    10 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendSelfCareFlashcard())
                    }
                    11 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendSalariesFlashcard())
                    }
                    12 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendBiLingualFlashcard())
                    }
                    13 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendMalesFlashcard())
                    }
                    14 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendHolisticFlashcard())
                    }
                    15 -> {
                        this@TrendsSubTopicActivity.startTrendsFlashcardActivity(Flashcards.trendPatientsFlashcard())
                    }
                }
            }
        })

    }
}