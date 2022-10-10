package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.databinding.ActivityFlowSubTopicsBinding
import com.abisayo.computerize1.databinding.ActivityTopics1Binding

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

    topicList.add(Topic(0, "FlowChart", "Types" ))
    topicList.add(Topic(0, "FlowCharts", "Characteristics" ))



    topicAdapter = SubTopicsAdapter(topicList)
    recyclerView.adapter = topicAdapter


    topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener{
        override fun onItemClick(position: Int) {
            if (position == 0) {
                val intent = Intent(this@FlowSubTopicsActivity, FlowCharacteristicsActivity::class.java)
                startActivity(intent)

            }

            if (position == 1) {
                val intent = Intent(this@FlowSubTopicsActivity, AlgorithmActivity::class.java)
                startActivity(intent)

            }
        }

    })


}
}