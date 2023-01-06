package com.abisayo.computerize1.OxygenTherapy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.R
import com.abisayo.computerize1.SubTopicsAdapter
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.data.startOxygenTherapyFlashCardActivity
import com.abisayo.computerize1.databinding.ActivityOxygenTherapySubTopicBinding

class OxygenTherapySubTopicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOxygenTherapySubTopicBinding
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
        binding = ActivityOxygenTherapySubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Oxygen Therapy", "Introduction"))
        topicList.add(Topic(0, "Oxygen Therapy", "Methods of Administration"))
        topicList.add(Topic(0, "Oxygen Therapy", "Toxicity"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@OxygenTherapySubTopicActivity.startOxygenTherapyFlashCardActivity(
                            Flashcards.oxygentherapyIntroduction())
                    }
                    1 -> {
                        this@OxygenTherapySubTopicActivity.startOxygenTherapyFlashCardActivity(
                            Flashcards.oxygentherapyMethodsOfOxygenAdministration())
                    }
                    2 -> {
                        this@OxygenTherapySubTopicActivity.startOxygenTherapyFlashCardActivity(
                            Flashcards.oxygentherapyOxygenToxicity())
                    }
                }
            }
        })

    }
}