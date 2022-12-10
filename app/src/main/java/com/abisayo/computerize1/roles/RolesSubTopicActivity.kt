package com.abisayo.computerize1.roles

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.flashcard.Flashcards
import com.abisayo.computerize1.SubTopicsAdapter
import com.abisayo.computerize1.Topic
import com.abisayo.computerize1.databinding.ActivityRolesSubTopicBinding
import com.abisayo.computerize1.startRolesFlashcardActivity

class RolesSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRolesSubTopicBinding
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
        binding = ActivityRolesSubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "Caregiver"))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "Communicator"))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "Teacher"))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "Client advocate"))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "Counsellor"))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "Change Agent"))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "Leader"))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "manager"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardCaregiverFlashcard())
                    }
                    1 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardCommunicationFlashcard())
                    }
                    2 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardTeacherFlashcard())
                    }
                    3 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardAdvocateFlashcard())
                    }
                    4 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardCounsellorFlashcard())
                    }
                    5 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardChangeFlashcard())
                    }
                    6 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardLeaderFlashcard())
                    }
                    7 -> {
                        this@RolesSubTopicActivity.startRolesFlashcardActivity(Flashcards.standardManagerFlashcard())
                    }
                }
            }
        })

    }
}