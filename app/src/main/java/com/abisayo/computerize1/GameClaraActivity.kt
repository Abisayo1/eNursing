package com.abisayo.computerize1

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
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
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityGameClaraBinding

class GameClaraActivity : AppCompatActivity() {
    val NextLevel = 2
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


        binding.constraint.setOnClickListener {
            if (trialNum == 5) {
                val intent = Intent(this, NextLevelActivity::class.java)
                intent.putExtra(Constants.TOTAL_QUESTIONS, trialNum)
                intent.putExtra(Constants.CORRECT_ANSWERS, i)
                intent.putExtra(Constants.NEXT_LEVEL, NextLevel)
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
            question.text = "She volunteered as a nurse during the America?"
            secondBtn.text = "Civil war"
            firstBtn.text = "Democracy"
        } else if (que == binding.btnChair) {
            question.text = "She organised what services?"
            secondBtn.text = "teaching"
            firstBtn.text = "nursing"
        } else if (que == binding.btnGown) {
            question.text = "She was the one who established the American?"
            firstBtn.text = "flag"
            secondBtn.text = "Red Cross"
        } else if (que == binding.btnLefthand) {
            question.text = "She persuaded the congress to ratify the treaty in what year?"
            firstBtn.text = "1882"
            secondBtn.text = "1992"
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

}