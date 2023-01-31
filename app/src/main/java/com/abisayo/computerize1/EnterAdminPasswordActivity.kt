package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.abisayo.computerize1.databinding.ActivityEnterAdminPasswordBinding

class EnterAdminPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnterAdminPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityEnterAdminPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val password = binding.editTextTextPassword3.text.toString().trim()

        binding.button.setOnClickListener {
            val password = binding.editTextTextPassword3.text.toString().trim()
            if (password == "MrsEbison84") {
                val intent = Intent(this, ManageLMSActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }else {
                Toast.makeText(this, "I am sorry, you are not eligible to add courses", Toast.LENGTH_LONG).show()
            }
        }
    }
}