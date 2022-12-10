package com.abisayo.computerize1

import android.app.Activity
import android.content.Intent
import com.abisayo.computerize1.admission.AdmissionFlashcardActivity
import com.abisayo.computerize1.flashcard.FlashCard
import com.abisayo.computerize1.historyOfNursing.HistoryFlashcardActivity
import com.abisayo.computerize1.roles.RolesFlashcardActivity
import com.abisayo.computerize1.trendsInNursing.TrendsFlashcardActivity

fun Activity.startHistoryFlashcardActivity(flashCards: ArrayList<FlashCard>){
    val activityIntent =
        Intent(this, HistoryFlashcardActivity::class.java)
    activityIntent.putExtra(Constants.EXTRA_FLASH_CARD, flashCards)
    startActivity(activityIntent)
}

fun Activity.startTrendsFlashcardActivity(flashCards: ArrayList<FlashCard>){
    val activityIntent =
        Intent(this, TrendsFlashcardActivity::class.java)
    activityIntent.putExtra(Constants.EXTRA_FLASH_CARD, flashCards)
    startActivity(activityIntent)
}

fun Activity.startRolesFlashcardActivity(flashCards: ArrayList<FlashCard>){
    val activityIntent =
        Intent(this, RolesFlashcardActivity::class.java)
    activityIntent.putExtra(Constants.EXTRA_FLASH_CARD, flashCards)
    startActivity(activityIntent)
}

fun Activity.startAdmissionFlashcardActivity(flashCards: ArrayList<FlashCard>){
    val activityIntent =
        Intent(this, AdmissionFlashcardActivity::class.java)
    activityIntent.putExtra(Constants.EXTRA_FLASH_CARD, flashCards)
    startActivity(activityIntent)
}