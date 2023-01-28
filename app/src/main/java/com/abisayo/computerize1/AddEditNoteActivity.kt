package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.abisayo.computerize1.databinding.ActivityAddEditNoteBinding
import com.abisayo.computerize1.models.Courses
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddEditNoteBinding
    lateinit var viewModel: NoteViewModel
    var noteID = -1
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        val noteType = intent.getStringExtra("noteType")
        if (noteType.equals("Edit")) {
            val noteTitle = intent.getStringExtra("noteTitle")
            val noteDesc = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteID", -1)

            binding.addUpdateBtn.setText("Update Course")
            binding.editNoteTitle.setText(noteTitle)
            binding.editNoteDescription.setText(noteDesc)
        } else {
            binding.addUpdateBtn.setText("Save Course")
        }

        binding.addUpdateBtn.setOnClickListener {
            val noteTitle = binding.editNoteTitle.text.toString().trim()
            val noteDescription = binding.editNoteDescription.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Courses")
            val Course = Courses(noteTitle, noteDescription)
            database.child(noteTitle).setValue(Course).addOnSuccessListener {
                Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }

            if (noteType.equals("Edit")) {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM yyyy - HH:mm")
                    val currentDate:String = sdf.format(Date())
                    val updateNote = Note(noteTitle,noteDescription,currentDate)
                    updateNote.id = noteID
                    viewModel.update(updateNote)
                    Toast.makeText(this, "Course Updated..", Toast.LENGTH_LONG)
                }
            }else {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM yyyy - HH:mm")
                    val currentDate:String = sdf.format(Date())
                    viewModel.addNote(Note(noteTitle, noteDescription, currentDate))
                    Toast.makeText(this, "Course Added.. ", Toast.LENGTH_LONG)


                }
            }
            startActivity(Intent(applicationContext, NoteActivity::class.java))
            this.finish()
        }
    }
}