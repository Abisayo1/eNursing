package com.abisayo.computerize1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.abisayo.computerize1.databinding.ActivityGameClaraBinding
import com.abisayo.computerize1.databinding.ActivityHistoryQuizBinding
import com.abisayo.computerize1.databinding.ActivityPuzzleBinding

class GameClaraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameClaraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityGameClaraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            binding.score.visibility = View.VISIBLE

//            Toast.makeText(this, "mCorrectAnswers", Toast.LENGTH_SHORT).show()
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            binding.score.startAnimation(animationSlideUp)

            binding.score.visibility = View.INVISIBLE

        }




    }
}