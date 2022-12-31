package com.abisayo.computerize1

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.abisayo.computerize1.databinding.ActivityGameClaraBinding
import com.abisayo.computerize1.databinding.ActivityHistoryQuizBinding
import com.abisayo.computerize1.databinding.ActivityPuzzleBinding
import com.abisayo.computerize1.databinding.DialogLayoutBinding

class GameClaraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameClaraBinding
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = getSharedPreferences("ww", Context.MODE_PRIVATE)
        val savedInt = sharedPreferences?.getInt("m", 9)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityGameClaraBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.btnHead.setOnClickListener {
           val dialogLayoutBinding = layoutInflater.inflate(R.layout.dialog_layout, null)

           val mydialog = Dialog(this)
           mydialog.setContentView(dialogLayoutBinding)

           mydialog.setCancelable(true)
           mydialog.show()

           val btn = dialogLayoutBinding.findViewById<Button>(R.id.btn_login)
           btn.setOnClickListener {
               Toast.makeText(this, "$i", Toast.LENGTH_SHORT).show()
               mydialog.dismiss()
           }
       }



        binding.button3.setOnClickListener {
            binding.score.visibility = View.VISIBLE

            i++
            binding.score.text = "$i"
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            binding.score.startAnimation(animationSlideUp)

            binding.score.visibility = View.INVISIBLE

        }




    }

}