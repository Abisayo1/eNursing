package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.abisayo.computerize1.Games.GameClaraActivity
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityEnterNameQuizBinding
import com.abisayo.computerize1.databinding.ActivityNoteBinding

class EnterNameQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnterNameQuizBinding
    var topic = "game"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityEnterNameQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.editText.text.toString().trim()
        topic = intent.getStringExtra(Constants.TOPIC).toString()



        binding.button.setOnClickListener {
            if (topic=="game"){
                val intent = Intent(this, GameClaraActivity::class.java)
                intent.putExtra(Constants.STUDENT_NAME, name)
                intent.putExtra(Constants.TOPIC, topic)
                startActivity(intent)
                finish()
            } else {
                val name = binding.editText.text.toString().trim()
                if (name.isNotEmpty()) {
                    val intent = Intent(this, HistoryQuizActivity::class.java)
                    intent.putExtra(Constants.STUDENT_NAME, name)
                    intent.putExtra(Constants.TOPIC, topic)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}

