package com.abisayo.computerize1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.databinding.ActivityNoteBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteActivity : AppCompatActivity(), NoteClickDeleteInterface, NoteClickInterface {
    private lateinit var binding: ActivityNoteBinding
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notesRecycler.layoutManager = LinearLayoutManager(this)

        val noteRvAdapter = NoteRVAdapter(this, this, this)
        binding.notesRecycler.adapter = noteRvAdapter
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNote.observe(this, Observer { list ->
            list?.let {
                noteRvAdapter.updateList(it)
            }
        })

        binding.FABaddNote.setOnClickListener {
            val intent = Intent(this@NoteActivity, AddEditNoteActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    override fun onDeleteIconClick(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, "${note.noteTitle} Deleted", Toast.LENGTH_LONG)
    }

    override fun onNoteClick(note: Note) {
        val intent = Intent(this@NoteActivity, AddEditNoteActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("noteTitle", note.noteTitle)
        intent.putExtra("noteDescription", note.noteDescription)
        intent.putExtra("noteID", note.id)
        startActivity(intent)
        this.finish()
    }
}