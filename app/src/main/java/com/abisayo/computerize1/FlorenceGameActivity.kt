package com.abisayo.computerize1

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
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityFlorenceGameBinding


class FlorenceGameActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityFlorenceGameBinding
    private var i = 0
    var previousScore = 0
    private var trialNum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityFlorenceGameBinding
            .inflate(layoutInflater)
        setContentView(binding.root)

        val  totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        previousScore = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)




        binding.constraint.setOnClickListener {
            if (trialNum == 7) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(Constants.TOTAL_QUESTIONS, totalQuestions + trialNum)
                intent.putExtra(Constants.CORRECT_ANSWERS, i + previousScore)
                intent.putExtra(Constants.ACTIVITY,  "MenInNursingGameActivity")
                startActivity(intent)
                finish()
            }
        }


        binding.florenceHead.setOnClickListener {
            openDialog(0, binding.florenceHead)
            deactivate(binding.florenceHead)
        }

        binding.florenceCloth.setOnClickListener {
            openDialog(0, binding.florenceCloth)
            deactivate(binding.florenceCloth)

        }

        binding.florenceLamp.setOnClickListener {
            openDialog(1, binding.florenceLamp)
            deactivate(binding.florenceLamp)

        }

        binding.florenceLeftArm.setOnClickListener {
            openDialog(1, binding.florenceLeftArm)
            deactivate(binding.florenceLeftArm)

        }

        binding.florenceLowerDress.setOnClickListener {
            openDialog(1, binding.florenceLowerDress)
            deactivate(binding.florenceLowerDress)

        }

        binding.florencePatientHead.setOnClickListener {
            openDialog(1, binding.florencePatientHead)
            deactivate(binding.florencePatientHead)

        }

        binding.stool.setOnClickListener {
            openDialog(1, binding.stool)
            deactivate(binding.stool)

        }

        binding.stool2.setOnClickListener {
            openDialog(0, binding.stool2)
            deactivate(binding.stool2)

        }

        binding.arch.setOnClickListener {
            openDialog(0, binding.arch)
            deactivate(binding.arch)
        }

        binding.leftArch.setOnClickListener {
            openDialog(1, binding.leftArch)
            deactivate(binding.leftArch)
        }



    }

    @SuppressLint("SetTextI18n", "InflateParams")
    fun openDialog(a: Int, que: Button) {
        var w = i + previousScore
        binding.scoreV.text = "$w"
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

        if (que == binding.florenceHead) {
            question.text = "Florence was born into a what wealthy and what family?"
            secondBtn.text = "intellectual"
            firstBtn.text = "merciful"
        } else if (que == binding.florenceCloth) {
            question.text = "Florence believed that she was called byv God to help?"
            secondBtn.text = "mankind"
            firstBtn.text = "animals"
        } else if (que == binding.florenceLamp) {
            question.text = "What was her family's reaction to becoming a nurse?"
            firstBtn.text = "opposition"
            secondBtn.text = "support"
        } else if (que == binding.florenceLeftArm) {
            question.text = "Where did Florence recieve nurse training?"
            firstBtn.text = "Kaiserswerth"
            secondBtn.text = "Chicago"
        } else if (que == binding.florenceLowerDress) {
            question.text = "In what year did Florence recieve nurse training?"
            firstBtn.text = "1847"
            secondBtn.text = "1971"
        } else if (que == binding.florencePatientHead) {
            question.text = "Where did Florence study?"
            firstBtn.text = "Paris"
            secondBtn.text = "Canada"
        } else if (que == binding.stool) {
            question.text = "What was Florence's position in a charity hospital in England?"
            firstBtn.text = "Superintendent"
            secondBtn.text = "Doctor"
        } else if (que == binding.stool2) {
            question.text = "She earned the title, 'Lady of the Lamp' during what?"
            firstBtn.text = "her studies"
            secondBtn.text = "the war"
        } else if (que == binding.arch) {
            question.text = "Following her return from war, Florence earned what honorarium from the English public?"
            firstBtn.text = "4000 pounds"
            secondBtn.text = "4500 pounds"
        } else if (que == binding.leftArch) {
            question.text = "The Nightingale Training School for Nurses was set up in what year?"
            firstBtn.text = "1860"
            secondBtn.text = "1980"
        }



        secondBtn.setOnClickListener {
            var w = i + previousScore
            binding.scoreV.text = "$w"
            if (a == 0) {
                i++
                secondBtn.setBackgroundResource(R.drawable.correct_option_border)
                firstBtn.setBackgroundResource(R.drawable.wrong_option_border)
                stopSound()
                playSound(R.raw.winning)
                binding.scoreV.text = "$w"
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
            binding.scoreV.text = "$w"
        }

        firstBtn.setOnClickListener {
            var w = i + previousScore
            binding.scoreV.text = "$w"
            if (a == 1) {
                i++
                firstBtn.setBackgroundResource(R.drawable.correct_option_border)
                secondBtn.setBackgroundResource(R.drawable.wrong_option_border)
                stopSound()
                playSound(R.raw.winning)
                binding.scoreV.text = "$w"
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
            binding.scoreV.text = "$w"
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