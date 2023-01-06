package com.abisayo.computerize1.oxygenation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.R
import com.abisayo.computerize1.SubTopicsAdapter
import com.abisayo.computerize1.assessment.AssessmentYoutubeActivity
import com.abisayo.computerize1.data.Flashcards
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.data.startOxygenationFlashCardActivity
import com.abisayo.computerize1.databinding.ActivityOxygenationSubTopicBinding

class OxygenationSubTopicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOxygenationSubTopicBinding
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
        binding = ActivityOxygenationSubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Oxygenation", "Introduction"))
        topicList.add(Topic(0, "Oxygenation", "Structure and Processes of Respiratory System"))
        topicList.add(Topic(0, "Oxygenation", "Pulmonary Ventilation"))
        topicList.add(Topic(0, "Oxygenation", "Alveolar Gas Exchange"))
        topicList.add(
            Topic(0, "Oxygenation", "Transport of Oxygen and CO2"))
        topicList.add(Topic(0, "Oxygenation", "Factors affecting Respiratory Functions"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@OxygenationSubTopicActivity.startOxygenationFlashCardActivity(Flashcards.oxygenationIntroFlashcard())
                    }
                    1 -> {
                        this@OxygenationSubTopicActivity.startOxygenationFlashCardActivity(Flashcards.oxygenationStructureAndProcessesOfTheRespiratorySystem())
                    }
                    2 -> {
                        this@OxygenationSubTopicActivity.startOxygenationFlashCardActivity(Flashcards.oxygenationPulmonaryVentilation())
                    }
                    3 -> {
                        this@OxygenationSubTopicActivity.startOxygenationFlashCardActivity(Flashcards.oxygenationAlveolarGasExchange())
                    }
                    4 -> {
                        this@OxygenationSubTopicActivity.startOxygenationFlashCardActivity(Flashcards.oxygenationTransportOfOxygenandCarbondioxide())
                    }
                    5 -> {
                        this@OxygenationSubTopicActivity.startOxygenationFlashCardActivity(Flashcards.oxygenationFactorsAffectingRespiratoryFunction())

                    }

                }
            }
        })

    }
}