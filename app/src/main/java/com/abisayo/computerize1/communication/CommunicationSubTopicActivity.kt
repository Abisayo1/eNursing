package com.abisayo.computerize1.communication

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.databinding.ActivityAdmissionSubTopicBinding
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.data.startCommunicationFlashcardActivity
import com.abisayo.computerize1.databinding.ActivityCommunicationSubTopicBinding

class CommunicationSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommunicationSubTopicBinding
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
        binding = ActivityCommunicationSubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Communication skills", "Introduction"))
        topicList.add(Topic(0, "Communication skills", "Examples of communication skills in Nursing"))
        topicList.add(Topic(0, "Communication skills", "How to improve communication skills in nursing"))
        topicList.add(Topic(0, "Communication skills", "Communication skills in nursing in the workplace"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@CommunicationSubTopicActivity.startCommunicationFlashcardActivity(Flashcards.communicationIntroFlashcard())
                    }
                    1 -> {
                        this@CommunicationSubTopicActivity.startCommunicationFlashcardActivity(Flashcards.communicationExamplesFlashcard())
                    }
                    2 -> {
                        this@CommunicationSubTopicActivity.startCommunicationFlashcardActivity(Flashcards.communicationImproveFlashcard())
                    }
                    3 -> {
                        this@CommunicationSubTopicActivity.startCommunicationFlashcardActivity(Flashcards.communicationWorkspaceFlashcard())
                    }

                }
            }
        })

    }
}