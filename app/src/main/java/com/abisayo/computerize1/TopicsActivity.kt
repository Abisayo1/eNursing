package com.abisayo.computerize1

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.OxygenTherapy.OxygenTherapySubTopicActivity
import com.abisayo.computerize1.data.Constants.EXTRA_CLOSE_APP
import com.abisayo.computerize1.admission.AdmissionSubTopicActivity
import com.abisayo.computerize1.assessment.AssessmentSubTopicActivity
import com.abisayo.computerize1.communication.CommunicationSubTopicActivity
import com.abisayo.computerize1.data.Topic
import com.abisayo.computerize1.databinding.ActivityTopics1Binding
import com.abisayo.computerize1.discharge.DischargeSubTopicActivity
import com.abisayo.computerize1.Algorithms.AlgorithmSubTopicActivity
import com.abisayo.computerize1.oxygenation.OxygenationSubTopicActivity
import com.abisayo.computerize1.roles.RolesSubTopicActivity
import com.abisayo.computerize1.standards.StandardsActivity
import com.abisayo.computerize1.Flowcharts.FlowchartsSubTopicActivity


class TopicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopics1Binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicList: ArrayList<Topic>
    private lateinit var topicAdapter: TopicAdapter
    private lateinit var builder : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityTopics1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        builder = AlertDialog.Builder(this)


        binding.imageView3.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedInt = sharedPreferences.getInt("score", 0)

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

        topicList.add(Topic(0, "Algorithms", ""))
        topicList.add(Topic(0, "Flowcharts", ""))
        topicList.add(Topic(0, "View Other Courses", ""))




        topicAdapter = TopicAdapter(topicList)
        recyclerView.adapter = topicAdapter



        this
            .onBackPressedDispatcher
            .addCallback(this,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        Intent(this@TopicsActivity, FirstActivity::class.java).also { intent ->
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra(EXTRA_CLOSE_APP, true)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            )

        topicAdapter.setOnItemClickListener(object : TopicAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
                    0 -> {
                        val intent =
                            Intent(this@TopicsActivity, AlgorithmSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    1 -> { if (savedInt>=6) {
                        val intent =
                            Intent(this@TopicsActivity, FlowchartsSubTopicActivity::class.java)
                        startActivity(intent)
                    } else {
                        message()

                    }

                    }
                    2 -> {
                        builder.setTitle("Alert!")
                            .setMessage("You will need an internet connection")
                            .setCancelable(true)
                            .setPositiveButton("Continue") { dialogInterface, it ->
                                val intent = Intent(this@TopicsActivity, DisplayCoursesActivity::class.java)
                                startActivity(intent)
                                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                                finish()
                            }
                            .setNegativeButton("No") { dialogInterface, it ->
                                dialogInterface.cancel()
                            }

                            .show()

                    }
                    3 -> {
                        val intent = Intent(this@TopicsActivity, RolesSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    4 -> {
                        val intent = Intent(this@TopicsActivity, AssessmentSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    5 -> {
                        val intent =
                            Intent(this@TopicsActivity, AdmissionSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    6 -> {
                        val intent =
                            Intent(this@TopicsActivity, DischargeSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    7 -> {
                        val intent =
                            Intent(this@TopicsActivity, CommunicationSubTopicActivity::class.java)
                        startActivity(intent)

                    }

                    8 -> {
                        val intent =
                            Intent(this@TopicsActivity, OxygenationSubTopicActivity::class.java)
                        startActivity(intent)

                    }

                    9 -> {
                        val intent =
                            Intent(this@TopicsActivity, OxygenTherapySubTopicActivity::class.java)
                        startActivity(intent)

                    }
                }
            }

        })


    }

    private fun message() {
        Toast.makeText(this, "You need to score at least 60% in the assessment test to unlock this course", Toast.LENGTH_LONG).show()
    }
}