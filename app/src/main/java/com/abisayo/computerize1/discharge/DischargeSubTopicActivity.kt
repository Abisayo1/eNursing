package com.abisayo.computerize1.discharge

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
import com.abisayo.computerize1.data.startAdmissionFlashcardActivity
import com.abisayo.computerize1.data.startDischargeFlashcardActivity
import com.abisayo.computerize1.databinding.ActivityDischargeSubTopicBinding

class DischargeSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDischargeSubTopicBinding
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
        binding = ActivityDischargeSubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Discharge process", "Introduction"))
        topicList.add(Topic(0, "Discharge process", "Process of Discharge Planning"))
        topicList.add(Topic(0, "Discharge process", "Structure (model) of Discharge Planning"))
        topicList.add(Topic(0, "Discharge process", "Usefulness of Discharge Planning and Outcome Measures"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@DischargeSubTopicActivity.startDischargeFlashcardActivity(Flashcards.dischargeIntroFlashcard())
                    }
                    1 -> {
                        this@DischargeSubTopicActivity.startDischargeFlashcardActivity(Flashcards.dischargeProcessFlashcard())
                    }
                    2 -> {
                        this@DischargeSubTopicActivity.startDischargeFlashcardActivity(Flashcards.dischargeStructureFlashcard())
                    }
                    3 -> {
                        this@DischargeSubTopicActivity.startDischargeFlashcardActivity(Flashcards.dischargeUsefulnessFlashcard())
                    }

                }
            }
        })

    }
}