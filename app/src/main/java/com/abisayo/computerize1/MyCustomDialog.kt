package com.abisayo.computerize1

import android.content.Context
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.abisayo.computerize1.databinding.ActivityGameClaraBinding
import com.abisayo.computerize1.databinding.DialogLayoutBinding


class MyCustomDialog: DialogFragment() {
    private lateinit var binding: ActivityGameClaraBinding
    private lateinit var binding1: DialogLayoutBinding
    var mCorrectAnswers = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corner);
        binding1 = DialogLayoutBinding.inflate(inflater, container, false)
        binding = ActivityGameClaraBinding.inflate(inflater, container, false)

        loadData()




           binding1.btnLogin.setOnClickListener {
               mCorrectAnswers++
               saveData()
               binding1.tvLogin.text = "I am"


           }
        return binding1.root
    }

    private fun loadData() {
        val sharedPreferences = this.activity?.getSharedPreferences("ww", MODE_PRIVATE)
        val savedInt = sharedPreferences?.getInt("m", 9)
        Toast.makeText(activity, "${savedInt}", Toast.LENGTH_SHORT).show()

    }

    private fun saveData() {
        val insertedInt  = mCorrectAnswers
        val sharedPreferences = this.activity?.getSharedPreferences("ww", MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putInt("m", insertedInt)
        editor?.apply()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("mc", mCorrectAnswers)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}