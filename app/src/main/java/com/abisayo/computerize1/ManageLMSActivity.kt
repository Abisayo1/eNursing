package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.abisayo.computerize1.databinding.ActivityFirstBinding
import com.abisayo.computerize1.databinding.ActivityMainBinding
import com.abisayo.computerize1.databinding.ActivityManageLmsactivityBinding

class ManageLMSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManageLmsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityManageLmsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkStudentScores.setOnClickListener {
            val intent = Intent(this, DisplayStudentScoresActivity::class.java)
            startActivity(intent)
        }

        binding.course.setOnClickListener {
            val intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }
    }
}