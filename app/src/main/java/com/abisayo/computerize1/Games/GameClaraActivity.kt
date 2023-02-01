package com.abisayo.computerize1.Games

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.abisayo.computerize1.NextLevelActivity
import com.abisayo.computerize1.R
import com.abisayo.computerize1.ResultActivity
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityGameClaraBinding

class GameClaraActivity : AppCompatActivity() {
    private val NextLevel = 2
    var mMediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityGameClaraBinding
    var i = 0
    var trialNum = 0
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

        openDialog()


        binding.constraint.setOnClickListener {
            if (trialNum == 5) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(Constants.TOTAL_QUESTIONS, trialNum)
                intent.putExtra(Constants.CORRECT_ANSWERS, i)
                intent.putExtra(Constants.NEXT_LEVEL, NextLevel)
                intent.putExtra(Constants.ACTIVITY,  "GameClaraActivity")
                intent.putExtra(Constants.TOPIC,  "Game")
                startActivity(intent)
                finish()
            }
        }


       binding.btnHead.setOnClickListener {
           openDialog(1, binding.btnHead)
           deactivate(binding.btnHead)
       }

        binding.clockBtn.setOnClickListener {
            openDialog(0, binding.clockBtn)
            deactivate(binding.clockBtn)

        }

      binding.btnChair.setOnClickListener {
          openDialog(1, binding.btnChair)
          deactivate(binding.btnChair)

      }

      binding.btnGown.setOnClickListener {
            openDialog(0, binding.btnGown)
            deactivate(binding.btnGown)

        }

        binding.btnLefthand.setOnClickListener {
            openDialog(1, binding.btnLefthand)
            deactivate(binding.btnLefthand)

        }



    }

    @SuppressLint("SetTextI18n", "InflateParams")
    fun openDialog(a: Int, que:Button) {
        stopSound()
        playSound(R.raw.click)
        trialNum++
        val dialogLayoutBinding = layoutInflater.inflate(R.layout.dialog_layout, null)
        val question = dialogLayoutBinding.findViewById<TextView>(R.id.tv_login)
        val secondBtn = dialogLayoutBinding.findViewById<TextView>(R.id.nursebtn)
        val firstBtn = dialogLayoutBinding.findViewById<TextView>(R.id.teacherbtn)
        val mydialog = Dialog(this)
        mydialog.setContentView(dialogLayoutBinding)
        mydialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mydialog.setCancelable(true)
        mydialog.show()

        if (que == binding.clockBtn) {
            question.text = "The rectangle shape in flowcharts represents"
            secondBtn.text = "processing"
            firstBtn.text = "input/output"
        } else if (que == binding.btnChair) {
            question.text = "What symbol is used at the beginning of flowcharts?"
            secondBtn.text = "diamond"
            firstBtn.text = "oval"
        } else if (que == binding.btnGown) {
            question.text = "In flowchart, diamond shaped symbol is used to represent"
            firstBtn.text = "error box"
            secondBtn.text = "decision box"
        } else if (que == binding.btnLefthand) {
            question.text = "Terminal symbol in a flowchart indicates the"
            firstBtn.text = "end"
            secondBtn.text = "decision"
        }

            secondBtn.setOnClickListener {
                binding.scoreV.text = "$i"
                if (a == 0) {
                    i++
                    binding.scoreV.text = "$i"
                    secondBtn.setBackgroundResource(R.drawable.correct_option_border)
                    firstBtn.setBackgroundResource(R.drawable.wrong_option_border)
                    stopSound()
                    playSound(R.raw.winning)
                } else {
                    firstBtn.setBackgroundResource(R.drawable.correct_option_border)
                    secondBtn.setBackgroundResource(R.drawable.wrong_option_border)
                    stopSound()
                    playSound(R.raw.losing)
                }

                firstBtn.isClickable = false
                secondBtn.isClickable = false

                Toast.makeText(this, "$i", Toast.LENGTH_SHORT).show()


                binding.score.visibility = View.VISIBLE
                binding.score.text = "$i"
                val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
                binding.score.startAnimation(animationSlideUp)

                binding.score.visibility = View.INVISIBLE
                binding.scoreV.text = "$i"
            }

            firstBtn.setOnClickListener {
                binding.scoreV.text = "$i"
                if (a == 1) {
                    i++
                    binding.scoreV.text = "$i"
                    firstBtn.setBackgroundResource(R.drawable.correct_option_border)
                    secondBtn.setBackgroundResource(R.drawable.wrong_option_border)
                    stopSound()
                    playSound(R.raw.winning)
                } else {
                    secondBtn.setBackgroundResource(R.drawable.correct_option_border)
                    firstBtn.setBackgroundResource(R.drawable.wrong_option_border)
                    stopSound()
                    playSound(R.raw.losing)
                }

                firstBtn.isClickable = false
                secondBtn.isClickable = false

//                Toast.makeText(this, "$i", Toast.LENGTH_SHORT).show()


                binding.score.visibility = View.VISIBLE
                binding.score.text = "$i"
                val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
                binding.score.startAnimation(animationSlideUp)
                binding.score.visibility = View.INVISIBLE
                binding.scoreV.text = "$i"
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

    @SuppressLint("SetTextI18n")
    fun openDialog() {
        val dialogLayoutBinding = layoutInflater.inflate(R.layout.dialog_layout, null)
        val question = dialogLayoutBinding.findViewById<TextView>(R.id.tv_login)
        val secondBtn = dialogLayoutBinding.findViewById<TextView>(R.id.nursebtn)
        val firstBtn = dialogLayoutBinding.findViewById<TextView>(R.id.teacherbtn)
        val mydialog = Dialog(this)
        mydialog.setContentView(dialogLayoutBinding)
        mydialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mydialog.setCancelable(true)
        mydialog.show()

        question.text ="Questions are hidden in various parts of the pictures. Tap around the pictures to discover them. Answer correctly to score points!"
        secondBtn.text = "Go back"
        firstBtn.text = "Got it"

        firstBtn.setOnClickListener {
            mydialog.dismiss()
        }

        secondBtn.setOnClickListener {
            onBackPressed()
        }



    }

}