package com.abisayo.computerize1.historyOfNursing

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.*
import com.abisayo.computerize1.databinding.ActivityHistorySubTopicBinding
import com.abisayo.computerize1.flashcard.Flashcards

class HistorySubTopicActivity : AppCompatActivity() {

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

        topicList.add(Topic(0, "History of Nursing", "Women’s roles and Status"))
        topicList.add(Topic(0, "History of Nursing", "Religion"))
        topicList.add(Topic(0, "History of Nursing", "War"))
        topicList.add(Topic(0, "History of Nursing", "Societal Attitude"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nFlorence Nightingale (1820-1910)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nClara Barton (1821-1912)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nLinda Richards (1841-1930)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nMary Mahoney (1845-1926)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nLilian Wald (1867-1940)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nLavinia Dock (1858-1956)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nMargaret Higgins Sanger (1879-1966)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nMary Breckinridge (1881-1965)"))
        topicList.add(Topic(0, "History of Nursing", "Nursing Leaders\nMen in Nursing"))
        topicList.add(Topic(0, "History of Nursing", "Videos To Watch"))


        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.womenRoleFlashcard1())
                    }
                    1 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.religionFlashcard())
                    }
                    2 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.warFlashcard())
                    }
                    3 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.societalAttitudeFlashcard())
                    }
                    4 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.florenceFlashcard())
                    }
                    5 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.claraFlashcard())
                    }
                    6 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.lindaFlashcard())
                    }
                    7 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.maryFlashcard())
                    }
                    8 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.lilianFlashcard())
                    }
                    9 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.laviniaFlashcard())
                    }
                    10 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.margaretFlashcard())
                    }
                    11 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.mary2Flashcard())
                    }
                    12 -> {
                        this@HistorySubTopicActivity.startHistoryFlashcardActivity(Flashcards.menFlashcard())
                    }
                }
            }
        })

    }
}