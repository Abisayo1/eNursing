package com.abisayo.computerize1.Algorithms

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityHistorySubTopicBinding
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.data.startHistoryFlashcardActivity

class AlgorithmSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistorySubTopicBinding
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
        binding = ActivityHistorySubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Algorithms", "Introduction"))
        topicList.add(Topic(0, "Algorithms", "Types"))
        topicList.add(Topic(0, "Algorithms", "Characteristics"))
        topicList.add(Topic(0, "Algorithms", "Importance"))
        topicList.add(Topic(0, "Algorithms", "Steps"))
        topicList.add(Topic(0, "Algorithms", "Examples"))

        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@AlgorithmSubTopicActivity.startHistoryFlashcardActivity(Flashcards.womenRoleFlashcard1())
                    }
                    1 -> {
                        this@AlgorithmSubTopicActivity.startHistoryFlashcardActivity(Flashcards.religionFlashcard())
                    }
                    2 -> {
                        this@AlgorithmSubTopicActivity.startHistoryFlashcardActivity(Flashcards.warFlashcard())
                    }
                    3 -> {
                        this@AlgorithmSubTopicActivity.startHistoryFlashcardActivity(Flashcards.societalAttitudeFlashcard())
                    }
                    4 -> {
                        this@AlgorithmSubTopicActivity.startHistoryFlashcardActivity(Flashcards.florenceFlashcard())
                    }
                    5 -> {
                        val intent = Intent(this@AlgorithmSubTopicActivity, AlgorithmExampleActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })

    }
}