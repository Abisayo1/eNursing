package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.Constants.EXTRA_FLASH_CARD
import com.abisayo.computerize1.databinding.ActivityFlowSubTopicsBinding
import com.abisayo.computerize1.flashcard.FlashCard
import com.abisayo.computerize1.historyOfNursing.HistoryFlashcardActivity

class FlowSubTopicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlowSubTopicsBinding
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
        binding = ActivityFlowSubTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "FlowChart", "Introduction"))
        topicList.add(Topic(0, "FlowCharts", "Elements"))
        topicList.add(Topic(0, "FlowCharts", "Guidelines"))
        topicList.add(Topic(0, "FlowCharts", "Advantages"))
        topicList.add(Topic(0, "FlowCharts", "Disadvantages"))
        topicList.add(Topic(0, "FlowCharts", "Examples"))
        topicList.add(Topic(0, "Flashcard", "Example Flashcards"))
        topicList.add(Topic(0, "Flashcard 2", "Example Flashcards 2"))



        topicAdapter = SubTopicsAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                if (position == 0) {
                val intent = Intent(this@FlowSubTopicsActivity, Learn::class.java)
                startActivity(intent)
                }

                when (position) {
                    1 -> {
                        val intent =
                            Intent(this@FlowSubTopicsActivity, FlowChartElelmetsActivity::class.java)
                        startActivity(intent)

                    }
                    2 -> {
                        val intent =
                            Intent(this@FlowSubTopicsActivity, FlowchartRulesActivity::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent =
                            Intent(this@FlowSubTopicsActivity, FlowchartAdvantagtesActivity::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(this@FlowSubTopicsActivity,
                            FlowchartDisadvantagesActivity::class.java)
                        startActivity(intent)
                    }
                    5 -> {
                        val intent =
                            Intent(this@FlowSubTopicsActivity, FlowchartExamplesActivity::class.java)
                        startActivity(intent)
                    }
                    6 -> {
                        val activityIntent =
                            Intent(this@FlowSubTopicsActivity, HistoryFlashcardActivity::class.java)
                        activityIntent.putExtra(EXTRA_FLASH_CARD, getExampleFlashCards())
                        startActivity(activityIntent)
                    }
                    7 -> {
                        val activityIntent =
                            Intent(this@FlowSubTopicsActivity, HistoryFlashcardActivity::class.java)
                        activityIntent.putExtra(EXTRA_FLASH_CARD, getExampleFlashCards2())
                        startActivity(activityIntent)
                    }
                }
            }

        })

    }
    private fun getExampleFlashCards(): ArrayList<FlashCard> {
        val flashCardList = arrayListOf<FlashCard>()
        flashCardList.add(FlashCard("What is Flowchart",
            getString(R.string.examples_flow4)))
        flashCardList.add(FlashCard("What is it used for ", "Stuff"))
        return flashCardList
    }

    private fun getExampleFlashCards2(): ArrayList<FlashCard> {
        val flashCardList = arrayListOf<FlashCard>()
        flashCardList.add(FlashCard("What is Flashcard 2",
            getString(R.string.examples_flow3)))
        flashCardList.add(FlashCard("What is 2 used for ", "Stuff 2"))
        return flashCardList
    }
}