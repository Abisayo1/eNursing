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
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityMenInNursingGameBinding

class MenInNursingGameActivity : AppCompatActivity() {
    val nextLevel = 3
    var mMediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityMenInNursingGameBinding
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
        binding = ActivityMenInNursingGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        previousScore = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        binding.scoreV.text = "$previousScore"




        binding.constraint.setOnClickListener {
            var w = i + previousScore
            binding.scoreV.text = "$w"
            if (trialNum == 7) {
                val intent = Intent(this, NextLevelActivity::class.java)
                intent.putExtra(Constants.TOTAL_QUESTIONS, totalQuestions + trialNum)
                intent.putExtra(Constants.CORRECT_ANSWERS, i + previousScore)
                intent.putExtra(Constants.ACTIVITY,  "MenInNursingGameActivity")
                intent.putExtra(Constants.NEXT_LEVEL, nextLevel)
                startActivity(intent)
                finish()
            }
        }


        binding.nurseHead.setOnClickListener {
            openDialog(0, binding.nurseHead)
            deactivate(binding.nurseHead)
        }

        binding.patientLeftChest.setOnClickListener {
            openDialog(1, binding.patientLeftChest)
            deactivate(binding.patientLeftChest)

        }

        binding.nurseLeftArm.setOnClickListener {
            openDialog(0, binding.nurseLeftArm)
            deactivate(binding.nurseLeftArm)

        }

        binding.patientCloth.setOnClickListener {
            openDialog(1, binding.patientCloth)
            deactivate(binding.patientCloth)

        }

        binding.patientHead.setOnClickListener {
            openDialog(1, binding.patientHead)
            deactivate(binding.patientHead)

        }

        binding.patientRightArm.setOnClickListener {
            openDialog(1, binding.patientRightArm)
            deactivate(binding.patientRightArm)

        }

        binding.sScope.setOnClickListener {
            openDialog(1, binding.sScope)
            deactivate(binding.sScope)

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

        if (que == binding.nurseHead) {
            question.text = "Men experienced discrimination due to?"
            secondBtn.text = "Gender"
            firstBtn.text = "Age"
        } else if (que == binding.nurseLeftArm) {
            question.text = "Most men were denied admission ton nursing programs in what century?"
            secondBtn.text = "20th"
            firstBtn.text = "19th"
        } else if (que == binding.patientCloth) {
            question.text = "Men in Nursing Organisation was founded in what year?"
            firstBtn.text = "1971"
            secondBtn.text = "1988"
        } else if (que == binding.patientHead) {
            question.text = "Who organised the group of male nurses in Chigago?"
            firstBtn.text = "Luther Christman"
            secondBtn.text = "Martin Luther"
        } else if (que == binding.patientLeftChest) {
            question.text = "The aim of the National Male Nurses Association was to recruit more what in nursing?"
            firstBtn.text = "Men"
            secondBtn.text = "Women"
        } else if (que == binding.patientRightArm) {
            question.text = "The organisation was renamed American Assembly for Men in Nursing when?"
            firstBtn.text = "1981"
            secondBtn.text = "1988"
        } else if (que == binding.sScope) {
            question.text = "The National Male Nurses Association was formed by how many groups?"
            firstBtn.text = "two"
            secondBtn.text = "three"
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