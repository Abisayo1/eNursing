package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abisayo.computerize1.databinding.ActivityCreateAccountBinding
import com.abisayo.computerize1.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class CreateAccount : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView8.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.editTextTextPassword.text.toString().trim()
            val pass = binding.editTextNumberPassword.text.toString().trim()
            val confirmPass = binding.editTextTextPassword2.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {


                }else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
        }else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}