package com.abisayo.computerize1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.abisayo.computerize1.Games.GameClaraActivity
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityResultBinding
import com.abisayo.computerize1.Algorithms.HistoryQuizActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    var handler: Handler? = null
    private lateinit var progressText : TextView
    var i = 0
    var j = 0
    var correctAnswers = 999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goHome.setOnClickListener {
            val intent = Intent(this, TopicsActivity::class.java)
            startActivity(intent)
            finish()
        }

        val  totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val activity = intent.getStringExtra(Constants.ACTIVITY)
        val topic = intent.getStringExtra(Constants.TOPIC)

        saveData()

//        Toast.makeText(this, "$activity", Toast.LENGTH_SHORT).show()

        binding.tryAgain.setOnClickListener {
            if (activity == "MenInNursingGameActivity") {
                val intent = Intent(this, GameClaraActivity::class.java)
                startActivity(intent)
                finish()
            } else if (activity == "GameClaraActivity"){
                val intent = Intent(this, GameClaraActivity::class.java)
                startActivity(intent)
                finish()
            } else if (activity == "PuzzleActivity") {
                val intent = Intent(this, PuzzleActivity::class.java)
                startActivity(intent)
                finish()
            }

            when (activity) {
                "MenInNursingGameActivity" -> {
                    val intent = Intent(this, GameClaraActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                "GameClaraActivity" -> {
                    val intent = Intent(this, GameClaraActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                "PuzzleActivity" -> {
                    val intent = Intent(this, PuzzleActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            when (topic) {
                "History" -> {
                    val intent = Intent(this, HistoryQuizActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }
        }

        when {
            correctAnswers <= (totalQuestions / 2) -> {
                binding.motiv.text = "Ouch! It seems you need to study this topic one more time."
            }
            correctAnswers == (totalQuestions / 2) -> {
                binding.motiv.text = "An average performance. You can do better!"
            }
            correctAnswers == totalQuestions -> {
                binding.motiv.text = "Great job computer expert!"
            }
            else -> {
                binding.motiv.text = "Nice! You can do better!"
            }
        }

        i = correctAnswers
        j = totalQuestions
        binding.progressBar.max = totalQuestions

        handler = Handler(Handler.Callback {
            binding.progressBar.progress = i
            binding.progressText.text = "${i}/${binding.progressBar.max}"
            handler?.sendEmptyMessageDelayed(0, 100)

            true
        })

        handler?.sendEmptyMessage(0)
}

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putInt("score", correctAnswers)
        }.apply()


    }
}