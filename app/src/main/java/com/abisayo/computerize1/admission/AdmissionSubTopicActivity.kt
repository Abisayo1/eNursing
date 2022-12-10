package com.abisayo.computerize1.admission

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.databinding.ActivityAdmissionSubTopicBinding
import com.abisayo.computerize1.databinding.ActivityTrendSubTopicBinding
import com.abisayo.computerize1.flashcard.Flashcards

class AdmissionSubTopicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdmissionSubTopicBinding
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
        binding = ActivityAdmissionSubTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Admission process", "Introduction and Purpose"))
        topicList.add(Topic(0, "Admission process", "Types of Admission"))
        topicList.add(Topic(0, "Admission process", "Nursing Responsibilities"))
        topicList.add(Topic(0, "Admission process", "Admission Equipment"))
        topicList.add(Topic(0, "Admission process", "Nursing Responsibilities in admitting the Pediatric Patient"))
        topicList.add(Topic(0, "Admission process", "Special Considerations"))
        topicList.add(Topic(0, "Admission process", "Legal Aspects of Patient Admission"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@AdmissionSubTopicActivity.startAdmissionFlashcardActivity(Flashcards.admissionIntroFlashcard())
                    }
                    1 -> {
                        this@AdmissionSubTopicActivity.startAdmissionFlashcardActivity(Flashcards.admissionTypesFlashcard())
                    }
                    2 -> {
                        this@AdmissionSubTopicActivity.startAdmissionFlashcardActivity(Flashcards.admissionResponsibilitiesFlashcard())
                    }
                    3 -> {
                        this@AdmissionSubTopicActivity.startAdmissionFlashcardActivity(Flashcards.admissionEquipmentsFlashcard())
                    }
                    4 -> {
                        this@AdmissionSubTopicActivity.startAdmissionFlashcardActivity(Flashcards.admissionPediatricFlashcard())
                    }
                    5 -> {
                        this@AdmissionSubTopicActivity.startAdmissionFlashcardActivity(Flashcards.admissionSpecialFlashcard())
                    }
                    6 -> {
                        this@AdmissionSubTopicActivity.startAdmissionFlashcardActivity(Flashcards.admissionLegalFlashcard())
                    }
                }
            }
        })

    }
}