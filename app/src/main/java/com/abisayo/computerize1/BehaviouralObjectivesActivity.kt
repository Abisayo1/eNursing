package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abisayo.computerize1.Algorithms.AlgorithmSubTopicActivity
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityBehaviouralObjectivesBinding
import com.abisayo.computerize1.databinding.ActivityHistoryFlashcardBinding
import com.abisayo.computerize1.databinding.ActivityTrendsFlashcardBinding

class BehaviouralObjectivesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBehaviouralObjectivesBinding
    var topic = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBehaviouralObjectivesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Behavioural objectives")

        topic = intent.getStringExtra(Constants.TOPIC).toString()

        if (topic == "Algorithms") {
            binding.flowDisList.text = getString(R.string.algo_beh)
            binding.button.setOnClickListener {
                val intent = Intent(this, AlgorithmSubTopicActivity::class.java)
                startActivity(intent)
            }
        } else if (topic == "Flowcharts") {

            binding.flowDisList.text = getString(R.string.flow_beh)
            binding.button.setOnClickListener {
                val intent = Intent(this, FlowchartSubtopicAdapter::class.java)
                startActivity(intent)

            }
        }
    }
}