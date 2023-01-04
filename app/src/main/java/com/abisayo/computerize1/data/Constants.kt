package com.abisayo.computerize1.data

import com.abisayo.computerize1.R

object Constants {

    const val EXTRA_FLASH_CARD = "EXTRA_FLASH_CARD"
    const val EXTRA_CLOSE_APP = "EXTRA_CLOSE_APP"
    const val TOPIC: String = "topic"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"
    const val NEXT_LEVEL = "next_level"
    const val ACTIVITY = "activity"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"One perspective for consideration in the history of nursing is?",
            0,
            "War",
            "Peace",
            "Turbulence",
            "Calmness",
            1
        )

        questionsList.add(que1)


        val que2 = Question(
            2,"The care and nurture of family members and infants are primarily whose role?",
            0,
            "male",
            "baby",
            "animal",
            "female",
            4
        )

        questionsList.add(que2)


        val que3 = Question(
            3,"What is the nation's largest health care profession?",
            0,
            "teaching",
            "surgery",
            "nursing",
            "red cross",
            3
        )

        questionsList.add(que3)


        val que4 = Question(
            4,"An example of nursing role include?",
            0,
            "caring",
            "sewing",
            "teaching",
            "breast-feeding",
            1
        )

        questionsList.add(que4)


        val que5 = Question(
            5,"One thing that necessitated the need for nurses is?",
            (R.drawable.flow_eample2),
            "peace",
            "wealth",
            "life",
            "war",
            4
        )

        questionsList.add(que5)

        val que6 = Question(
            6,"An example of a war that necessitated the need for nurses is?",
            (R.drawable.flow_qeu6),
            "The Crimean war of 1854-1856",
            "The jaundice attack of 1240",
            "World war 2",
            "The Biafran war",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,"On whose delegation did Florence Nightingale provide care to the sick and injured?",
            (R.drawable.flow_eample2),
            "George Bush",
            "Mary Slessor",
            "Sir Sydney Herbert",
            "Herbert Astern",
            3
        )

        questionsList.add(que7)

        val que8 = Question(
            8,"How were the military hospitals transformed?",
            (R.drawable.flow_eample2),
            "By setting up sanitation practices",
            "By loitering",
            "By fighting civil wars",
            "By issuing commands",
            1
        )

        questionsList.add(que8)

        val que9 = Question(
            9,"Who cared for the wounded and dying soldiers on the battlefield of the American civil war?",
            (R.drawable.flow_eample2),
            "Mother Theresa",
            "George Washington",
            "Mother Biekerdyke",
            "Mother nature",
            3
        )
        questionsList.add(que9)

        val que10 = Question(
            10,"Which of the following volunteered to give care to the injured soldiers in military hospitals?",
            (R.drawable.flow_eample2),
            "Isaac Newton",
            "Walt Whitman",
            "James Edward",
            "John Mason",
            2
        )

        questionsList.add(que10)



        return questionsList
    }
}