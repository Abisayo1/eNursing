package com.abisayo.computerize1

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"


    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"What is an algorithm?",
            (R.drawable.flowchart),
            "Algorthm is nothing",
            "Argentina",
            "What are you terying to say?",
            "I do not know",
            1
        )

        questionsList.add(que1)


        val que2 = Question(
            1,"What is an algorithm?",
            (R.drawable.flowchart),
            "Algorthm is nothing",
            "Argentina",
            "What are you terying to say?",
            "I do not know",
            1
        )

        questionsList.add(que2)


        val que3 = Question(
            1,"What is an algorithm?",
            (R.drawable.flowchart),
            "Algorthm is nothing",
            "Argentina",
            "What are you terying to say?",
            "I do not know",
            1
        )

        questionsList.add(que3)


        val que4 = Question(
            1,"What is an algorithm?",
            (R.drawable.flowchart),
            "Algorthm is nothing",
            "Argentina",
            "What are you terying to say?",
            "I do not know",
            1
        )

        questionsList.add(que4)

        return questionsList
    }
}