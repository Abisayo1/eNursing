package com.abisayo.computerize1.data

import com.abisayo.computerize1.R

object Constants {

    const val EXTRA_FLASH_CARD = "EXTRA_FLASH_CARD"
    const val EXTRA_CLOSE_APP = "EXTRA_CLOSE_APP"
    const val TOPIC: String = "topic"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun getHistoryQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"What is flowchart?",
            0,
            "It is a graphical representation of an algorithm",
            "It is also known as an algorithm",
            "It is a barchart ",
            "It is an input device",
            1
        )

        questionsList.add(que1)


        val que2 = Question(
            2,"Flowcharts make use of _____ to indicate the flow of information",
            0,
            "code",
            "cards",
            "RAM",
            "symbols",
            4
        )

        questionsList.add(que2)


        val que3 = Question(
            3,"The oval symbol indicates _____",
            0,
            "inout/output",
            "processing",
            "terminal",
            "screen",
            3
        )

        questionsList.add(que3)


        val que4 = Question(
            4,"The diamond symbol represents?",
            0,
            "decision",
            "connectors",
            "terminal?",
            "jewelry",
            1
        )

        questionsList.add(que4)


        val que5 = Question(
            5,"The flowchart in the diagram above is used to?",
            (R.drawable.flow_eample2),
            "Find the even number among three integers",
            "Find the odd number among three integers",
            "Solve quadratic equation",
            "Find the largest among three numbers",
            4
        )

        questionsList.add(que5)

        val que6 = Question(
            6,"The flowchart in the diagram above is used to?",
            (R.drawable.flow_qeu6),
            "Determine Whether a Temperature is Below or Above the Freezing Point",
            "Determine the scale a temperature is calculated in",
            "Order for a temperature using e-commerce app",
            "Convert from Kelvin to Celsius scale",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,"What symbol is used to show the flow of data around the systems flow chart?",
            (R.drawable.flow_eample2),
            "square",
            "rectangle",
            "arrow",
            "diamond",
            3
        )

        questionsList.add(que7)

        val que8 = Question(
            8,"Which of the following words is typically used to end flowchart diagrams?",
            (R.drawable.flow_eample2),
            "stop",
            "start",
            "almost",
            "terminate",
            1
        )

        questionsList.add(que8)

        val que9 = Question(
            9,"What is the major reason why flowcharts are often bypassed by developers?",
            (R.drawable.flow_eample2),
            "Experts don't need flowcharts",
            "Flowcharts requires expensive equipments to draw",
            "Complex programs make flowcharts difficult to draw",
            "It is not necessary",
            3
        )

        val que10 = Question(
            10,"Which of the following words is typically used to start flowchart diagrams?",
            (R.drawable.flow_eample2),
            "stop",
            "start",
            "almost",
            "terminate",
            2
        )

        questionsList.add(que10)

        questionsList.add(que9)

        return questionsList
    }
}