package com.abisayo.computerize1.historyOfNursing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.data.Question
import com.abisayo.computerize1.R
import com.abisayo.computerize1.ResultActivity
import com.abisayo.computerize1.databinding.ActivityHistoryQuizBinding

class HistoryQuizActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHistoryQuizBinding
    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers = 0
    private lateinit var builder : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityHistoryQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)
        binding.next.setOnClickListener(this)
    }

    override fun onBackPressed() {
        builder.setTitle("Alert!")
            .setMessage("Do you want to leave quiz?")
            .setCancelable(true)
            .setPositiveButton("Yes") { dialogInterface, it ->
                finish()
            }
            .setNegativeButton("No") { dialogInterface, it ->
                dialogInterface.cancel()
            }

            .show()
    }

    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentPosition -1]
        defaultOptionsView()

        if (mCurrentPosition == 5) {
            binding.imgQuestion.isVisible = true
        }else binding.imgQuestion.isVisible = mCurrentPosition == 6

        if (mCurrentPosition == mQuestionsList!!.size){
            binding.nxt.text = "Finish"
        }

        binding.question.text = question!!.question
        binding.imgQuestion.setImageResource(question.image)
        binding.option1.text = question.optionOne
        binding.option2.text = question.optionTwo
        binding.option3.text = question.optionThree
        binding.option4.text = question.optionFour

        builder = AlertDialog.Builder(this)

    }

    private fun defaultOptionsView(){
        binding.option1.isClickable = true
        binding.option2.isClickable = true
        binding.option3.isClickable = true
        binding.option4.isClickable = true
        binding.next.isVisible = false
        binding.nxt.isVisible = false
        binding.right.isVisible = false
        val options = ArrayList<TextView>()
        options.add(0, binding.option1)
        options.add(1, binding.option2)
        options.add(2, binding.option3)
        options.add(3, binding.option4)

        for (option in options) {
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }

    }

    override fun onClick(p0: View?) {

        when(p0?.id) {
            R.id.option1 -> {
                selectedOptionView(binding.option1, 1)
                click()
            }
            R.id.option2 -> {
                selectedOptionView(binding.option2, 2)
                click()
            }
            R.id.option3 -> {
                selectedOptionView(binding.option3, 3)
                click()
            }
            R.id.option4 -> {
                selectedOptionView(binding.option4, 4)
                click()

            }

            R.id.next -> {
                setQuestion()
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }else -> {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        intent.putExtra(Constants.TOPIC, "History")
                        startActivity(intent)
                        finish()
                    }
                    }
                }
            }
        }

    }

    private fun click(){
        binding.nxt.isVisible = true
        binding.next.isVisible = true
        binding.right.isVisible = true
        val question = mQuestionsList?.get(mCurrentPosition -1)
        if (question!!.correctAnswer != mSelectedOptionPosition){
            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
            binding.right.text = "Wrong.."
        } else {
            answerView(question.correctAnswer, R.drawable.correct_option_border)
            binding.right.text = "Right.."
            mCorrectAnswers++
        }
        answerView(question.correctAnswer, R.drawable.correct_option_border)

        if (mCurrentPosition == mQuestionsList!!.size){
            binding.nxt.text = "finish"
        }
        mSelectedOptionPosition = 0

        binding.option1.isClickable = false
        binding.option2.isClickable = false
        binding.option3.isClickable = false
        binding.option4.isClickable = false
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                binding.option1.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                binding.option2.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                binding.option3.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                binding.option4.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }


    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        mSelectedOptionPosition = selectedOptionNum
    }

}