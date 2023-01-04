package com.abisayo.computerize1

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.abisayo.computerize1.Games.FlorenceGameActivity
import com.abisayo.computerize1.Games.MenInNursingGameActivity
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityNextLevelBinding

class NextLevelActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityNextLevelBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityNextLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val nextLevel = intent.getIntExtra(Constants.NEXT_LEVEL, 0)
        val activity = intent.getStringExtra(Constants.ACTIVITY)

        playSound(R.raw.upbeat)

        binding.nextLevel.text = "Level $nextLevel!"


        binding.checkScore.setOnClickListener {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, totalQuestions)
                    intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                    intent.putExtra(Constants.ACTIVITY,  activity)
                    startActivity(intent)
                    finish()

        }

        binding.nextLevelBtn.setOnClickListener {
            if (nextLevel == 3) {
                val intent = Intent(this, FlorenceGameActivity::class.java)
                intent.putExtra(Constants.TOTAL_QUESTIONS, totalQuestions)
                intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                startActivity(intent)
                finish()
            } else if (nextLevel == 2) {
                val intent = Intent(this, MenInNursingGameActivity::class.java)
                intent.putExtra(Constants.TOTAL_QUESTIONS, totalQuestions)
                intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                startActivity(intent)
                finish()
            }


        }

    }

    // 1. Plays the water sound
    fun playSound(sound: Int) {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, sound)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()

    }

    // 2. Pause playback
    fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
    }

    // 3. Stops playback
    fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    // 4. Destroys the MediaPlayer instance when the app is closed
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }


    fun deactivate(button: Button) {
        button.isClickable = false

    }

}