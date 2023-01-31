package com.abisayo.computerize1.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abisayo.computerize1.StudentScoresRepository

class StudentScoresViewModel : ViewModel() {

    private val repository : StudentScoresRepository
    private val _allScores = MutableLiveData<List<Scores>>()
    val allScores : LiveData<List<Scores>> = _allScores

    init {
        repository = StudentScoresRepository().getInstance()
        repository.loadSCores(_allScores)
    }
}
