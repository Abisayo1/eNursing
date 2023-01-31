package com.abisayo.computerize1

import androidx.lifecycle.MutableLiveData
import com.abisayo.computerize1.models.Scores
import com.google.firebase.database.*

class StudentScoresRepository {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("Scores")

    @Volatile private var INSTANCE : StudentScoresRepository?= null

    fun getInstance() : StudentScoresRepository {
        return INSTANCE ?: synchronized(this) {

            val instance = StudentScoresRepository()
            INSTANCE = instance
            instance
        }

    }

    fun loadSCores(courseList : MutableLiveData<List<Scores>>){

        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {

                    val _scoreList : List<Scores> = snapshot.children.map { dataSnapshot ->

                        dataSnapshot.getValue(Scores::class.java)!!

                    }

                    courseList.postValue(_scoreList)

                }catch (e: Exception){

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}