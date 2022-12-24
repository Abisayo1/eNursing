package com.abisayo.computerize1

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.customview.widget.ViewDragHelper
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Question
import com.abisayo.computerize1.databinding.ActivityAdmissionFlashcardBinding
import com.abisayo.computerize1.databinding.ActivityMainBinding
import com.abisayo.computerize1.databinding.ActivityPuzzleBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar



class PuzzleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPuzzleBinding
    private lateinit var builder: AlertDialog.Builder
    private var i = 0
    private var j: Int = 1
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
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityPuzzleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuestionsList = Constants.getQuestions()



        j = intent.getIntExtra("i", 0)
        Toast.makeText(this, "$j", Toast.LENGTH_SHORT).show()

        setQuestion(j)
        j++

        binding.button.setOnClickListener {

            defaultView(j)
            j = j
            setQuestion(j)


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
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)
                    if (j == mQuestionsList!!.size) {
                        binding.button.text = "FINISH"
                    } else {
                        binding.button.text = "Next"
                    }

                               view.invalidate()

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
                binding.dragView.isLongClickable = false
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
        val intent = Intent(this, PuzzleActivity::class.java)
        intent.putExtra("i", p)
        startActivity(intent)
        finish()
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




}



    


