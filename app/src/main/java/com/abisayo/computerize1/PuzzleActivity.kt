package com.abisayo.computerize1

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.customview.widget.ViewDragHelper
import androidx.drawerlayout.widget.DrawerLayout
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Question
import com.abisayo.computerize1.databinding.ActivityAdmissionFlashcardBinding
import com.abisayo.computerize1.databinding.ActivityMainBinding
import com.abisayo.computerize1.databinding.ActivityPuzzleBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar



class PuzzleActivity : AppCompatActivity() {
    var dialogOpen = 0
    private lateinit var toggle: ActionBarDrawerToggle
    var mMediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityPuzzleBinding
    private lateinit var builder: AlertDialog.Builder
    private var i = 0
    private var j: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
//        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        dialogOpen = intent.getIntExtra("a", 0)

        if (dialogOpen == 0) {
            openDialog()
            dialogOpen++
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityPuzzleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuestionsList = Constants.getQuestions()

        playSound(R.raw.upbeat)



        j = intent.getIntExtra("i", 0)
        mCorrectAnswers = intent.getIntExtra("k", 0)

        setQuestion(j)
        j++

        if (j == 10) {
            binding.button.text = "Finish"
        }


        binding.button.setOnClickListener {

            defaultView(j)
            j = j

        }

        builder = AlertDialog.Builder(this)


        binding.llTop.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)
        binding.llRight.setOnDragListener(dragListener)
        binding.tt.setOnDragListener(dragListeners)
        binding.llBottomRight.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)


        binding.dragView.setOnLongClickListener {
            val clipText = "This is our ClipData text"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true

        }


    }


    override fun onBackPressed() {
        builder.setTitle("Alert!")
            .setMessage("Do you want to leave puzzle?")
            .setCancelable(true)
            .setPositiveButton("Yes") { dialogInterface, it ->
                finish()
            }
            .setNegativeButton("No") { dialogInterface, it ->
                dialogInterface.cancel()
            }

            .show()
    }


    val dragListener = View.OnDragListener { view, event ->
        binding.dragView.visibility = View.INVISIBLE
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                binding.txtBottom.visibility = View.VISIBLE
                binding.txtTop.visibility = View.VISIBLE
                binding.txtBottomRight.visibility = View.VISIBLE
                binding.txtRight.visibility = View.VISIBLE
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)

            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                if (view == binding.llBottom) {
                    mSelectedOptionPosition = 3
                    binding.txtBottom.visibility = View.GONE
                } else if (view == binding.llTop) {
                    mSelectedOptionPosition = 1
                    binding.txtTop.visibility = View.GONE
                } else if (view == binding.llRight) {
                    mSelectedOptionPosition = 2
                    binding.txtRight.visibility = View.GONE
                } else if (view == binding.llBottomRight) {
                    mSelectedOptionPosition = 4
                    binding.txtBottomRight.visibility = View.GONE
                }

                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                    val question = mQuestionsList?.get(j -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                        Toast.makeText(this, "$mCorrectAnswers", Toast.LENGTH_SHORT).show()
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)
                    if (j == mQuestionsList!!.size) {
                        binding.button.text = "FINISH"
                    } else {
                        binding.button.text = "Next"
                    }

                               view.invalidate()

                binding.dragView.isLongClickable = false

                val v = event.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v)
                val destination = view as LinearLayout
                destination.addView(v)
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false

        }

    }


    val dragListeners = View.OnDragListener { view, event ->
        binding.dragView.visibility = View.VISIBLE
        when (event.action) {

            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {

                false
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {

                false
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                false

            }

            else -> false

        }


    }

    private fun setQuestion(u: Int) {
        val question = mQuestionsList!![u]

        if (u == mQuestionsList!!.size) {
            binding.button.isClickable = false
            binding.button.text = "Finish"
        } else{
            binding.button.text = "Next"
        }

        binding.dragView.text = question!!.question
        binding.txtTop.text = question.optionOne
        binding.txtRight.text = question.optionTwo
        binding.txtBottom.text = question.optionThree
        binding.txtBottomRight.text = question.optionFour



    }

    private fun defaultView(p: Int) {
        if (j == 10) {
            stopSound()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
            intent.putExtra(Constants.ACTIVITY, "PuzzleActivity")
            startActivity(intent)
            finish()
        } else {
            stopSound()
            val intent = Intent(this, PuzzleActivity::class.java)
            intent.putExtra("i", p)
            intent.putExtra("k", mCorrectAnswers)
            intent.putExtra("a", dialogOpen)
            startActivity(intent)
            finish()
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer){
            1 -> {
                binding.llTop.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2 -> {
                binding.llRight.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            3 -> {
                binding.llBottom.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            4 -> {
                binding.llBottomRight.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

        }
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

        question.text ="Drag the questions to the right square provided!"
        secondBtn.text = "Go back"
        firstBtn.text = "Got it"

        firstBtn.setOnClickListener {
            mydialog.dismiss()
        }

        secondBtn.setOnClickListener {
            onBackPressed()
        }



    }

    // 1. Plays the water sound
    fun playSound(sound: Int) {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, sound)
            mMediaPlayer!!.isLooping = true
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_item_one) {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
            finish()
        } else if (item.itemId == R.id.check_score) {
            stopSound()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
            intent.putExtra(Constants.ACTIVITY, "PuzzleActivity")
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)


    }


}



    


