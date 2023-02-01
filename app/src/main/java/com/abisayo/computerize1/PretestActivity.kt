package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityPretestBinding

class PretestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPretestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityPretestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, EnterNameQuizActivity::class.java)
            intent.putExtra(Constants.TOPIC, "Pretest")
            startActivity(intent)

        }

        binding.textView20.setOnClickListener {
            val intent = Intent(this, TopicsActivity::class.java)
            startActivity(intent)

        }
    }
}