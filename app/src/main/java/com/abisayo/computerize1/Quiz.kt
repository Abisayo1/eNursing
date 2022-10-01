package com.abisayo.computerize1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.abisayo.computerize1.databinding.ActivityQuizBinding


class Quiz : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding

    private lateinit var builder : AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_quiz)

        builder = AlertDialog.Builder(this)
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
    }

