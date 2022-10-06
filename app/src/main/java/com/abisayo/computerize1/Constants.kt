package com.abisayo.computerize1

object Constants {

    const val TOPIC: String = "topic"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"


    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"What is flowchart?",
            (R.drawable.flowchart),
            "It is a graphical representation of an algorithm",
            "It is also known as an algorithm",
            "It is a barchart ",
            "It is an input device",
            1
        )

        questionsList.add(que1)


        val que2 = Question(
            2,"Flowcharts make use of _____ to indicate the flow of information",
            (R.drawable.flowchart),
            "code",
            "cards",
            "RAM",
            "symbols",
            4
        )

        questionsList.add(que2)


        val que3 = Question(
            3,"The oval symbol indicates _____",
            (R.drawable.flowchart),
            "inout/output",
            "processing",
            "terminal",
            "screen",
            3
        )

        questionsList.add(que3)


        val que4 = Question(
            1,"The diamond symbol represents?",
            (R.drawable.flowchart),
            "decision",
            "connectors",
            "terminal?",
            "jewelry",
            1
        )

        questionsList.add(que4)

        return questionsList
    }

    fun getQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"What is algorithm?",
            (R.drawable.flowchart),
            "It is a graphical representation of an algorithm",
            "It is also known as an flowchart",
            "It is a recipe",
            "It is a set of rules to be followed in order to achieve a task",
            4
        )

        questionsList.add(que1)


        val que2 = Question(
            2,"_____ is NOT a type of algorithm",
            (R.drawable.flowchart),
            "FlowChart",
            "Brute Force",
            "Recursive",
            "Backtracking",
            1
        )

        questionsList.add(que2)


        val que3 = Question(
            3,"_______ Algorithm is characterized by breaking a problem into sub-problems, solving and then merging the solutions",
            (R.drawable.flowchart),
            "Brute Force",
            "Sorting algorithm",
            "Divide and Conquer",
            "Step by Step",
            3
        )

        questionsList.add(que3)


        val que4 = Question(
            1,"To write an algorithm, it is very essential to _____ ",
            (R.drawable.flowchart),
            "jump right into it",
            "wash your hands",
            "define the problem",
            "draw a flowchart",
            3
        )

        questionsList.add(que4)

        return questionsList
    }
}