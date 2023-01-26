package com.abisayo.computerize1

import androidx.lifecycle.LiveData

class NoteRepository(private val notesDao: NoteDao) {
    val allNotes: LiveData<List<Note>> =  notesDao.getAllNotes()

    suspend fun insert(note: Note){
        notesDao.insert(note)
    }

    suspend fun delete(note: Note){
        notesDao.delete(note)

    }

    suspend fun update(note: Note) {
        notesDao.update(note)
    }
}