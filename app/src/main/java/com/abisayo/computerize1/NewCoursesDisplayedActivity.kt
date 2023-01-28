package com.abisayo.computerize1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abisayo.computerize1.data.Constants
import com.abisayo.computerize1.databinding.ActivityNewCoursesDisplayedBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NewCoursesDisplayedActivity : AppCompatActivity() {

    private lateinit var database : DatabaseReference

    lateinit var binding: ActivityNewCoursesDisplayedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCoursesDisplayedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topic = intent.getStringExtra(Constants.TOPIC)

        database = FirebaseDatabase.getInstance().getReference("Courses")
        if (topic != null) {
            database.child(topic).get().addOnSuccessListener {
                if (it.exists()) {
                    val note = it.child("note").value
                    binding.flow.text = topic
                    binding.introText.text = note as CharSequence?
                    supportActionBar?.setTitle(topic)

                }else {
                    Toast.makeText(this, "", Toast.LENGTH_SHORT)
                }
            }.addOnFailureListener {
                Toast.makeText(this, "", Toast.LENGTH_SHORT)
            }
        }

        binding.flow.text = topic

    }
}