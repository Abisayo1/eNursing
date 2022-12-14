package com.abisayo.computerize1.assessment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.SubTopicsAdapter
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.data.startAssessmentFlashcardActivity
import com.abisayo.computerize1.databinding.ActivityAssessmentSubTopicBinding

class AssessmentSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAssessmentSubTopicBinding
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
        binding = ActivityAssessmentSubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Health assessment", "Introduction and Purpose"))
        topicList.add(Topic(0, "Health assessment", "Indications for health assessment"))
        topicList.add(Topic(0, "Health assessment", "Types/Levels of Health Assessment"))
        topicList.add(Topic(0, "Health assessment", "Types of Data"))
        topicList.add(Topic(0,
            "Pysical Examination for Objective Assessment",
            "Additional resource"))
        topicList.add(Topic(0, "Pysical Examination for Objective Assessment", "Videos"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@AssessmentSubTopicActivity.startAssessmentFlashcardActivity(Flashcards.assessmentIntroFlashcard())
                    }
                    1 -> {
                        this@AssessmentSubTopicActivity.startAssessmentFlashcardActivity(Flashcards.assessmentIndicationsFlashcard())
                    }
                    2 -> {
                        this@AssessmentSubTopicActivity.startAssessmentFlashcardActivity(Flashcards.assessmentTypesOrLevelsFlashcard())
                    }
                    3 -> {
                        this@AssessmentSubTopicActivity.startAssessmentFlashcardActivity(Flashcards.assessmentDataTypesFlashcard())
                    }
                    4 -> {
                        startActivity(Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://lms.rn.com/getpdf.php/2051.pdf")));
                    }
                    5 -> {
                        startActivity(Intent(this@AssessmentSubTopicActivity,
                            AssessmentYoutubeActivity::class.java))
                    }

                }
            }
        })

    }
}