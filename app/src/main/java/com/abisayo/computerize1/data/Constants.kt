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
            3,"_______ Algorithm is characterized by breaking a problem into sub-problems",
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

        val que5 = Question(
            5,"An algorithm uses mainly ______ to describe the steps ",
            (R.drawable.flowchart),
            "arrows",
            "words",
            "shapes",
            "diagram",
            2
        )

        questionsList.add(que5)

        val que6 = Question(
            6,"The unambiguous characteristic of an algorithm means that it can easily be _____",
            (R.drawable.flowchart),
            "understood",
            "drawn",
            "jumped",
            "dictated",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,"Algorithms must contain ____ and _____",
            (R.drawable.flowchart),
            "output and memory",
            "flowcharts and memory",
            "input and output",
            "databases and tables",
            3
        )

        questionsList.add(que7)

        val que8 = Question(
            8,"Every algorithm can be written in ____",
            (R.drawable.flowchart),
            "1 definite manner",
            "many different ways",
            "3 different ways",
            "only 2 different ways",
            2
        )

        questionsList.add(que8)

        val que9 = Question(
            9,"An algorithm is written in ______",
            (R.drawable.flowchart),
            "sign language",
            "human language",
            "animal language",
            "signing language",
            2
        )

        questionsList.add(que9)


        val que10 = Question(
            10,"Algorithms _______",
            (R.drawable.flowchart),
            "explains the problem",
            "must start, and terminate",
            "starts but does not terminate",
            "does not start and does not terminate",
            2
        )

        questionsList.add(que10)

        return questionsList
    }

    fun pretestQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"Algorithms and flowchart are two types of tools to explain the process of a program?",
            (R.drawable.flowchart),
            "Computing",
            "Program",
            "ICT",
            "Data flow",
            4
        )

        questionsList.add(que1)


        val que2 = Question(
            2,"Algorithms is the",
            (R.drawable.flowchart),
            "Object file for executing a program",
            "Step by step manner for executing a program",
            "Executable file for a program",
            "Source file manner for executing a program",
            2
        )

        questionsList.add(que2)


        val que3 = Question(
            3,"Which of the following is the pictorial representation of an algorithm?",
            (R.drawable.flowchart),
            "Data flow",
            "Algorithm",
            "Diagram",
            "Flowchart",
            4
        )

        questionsList.add(que3)

        val que4 = Question(
            4,"The shape above signifies what function in a flowchart?",
            (R.drawable.process),
            "connector",
            "input/output",
            "processing",
            "end",
            3
        )

        questionsList.add(que4)

        val que5 = Question(
            5,"Which of the following symbols is used at the beginning of a flowchart?",
            (R.drawable.flowchart),
            "Oval",
            "Diamond",
            "Rectangle",
            "Sphere",
            1
        )

        questionsList.add(que5)

        val que6 = Question(
            6,"A benefit of using flowcharts is that they",
            (R.drawable.flowchart),
            "help you program fast",
            "write the program for you",
            "social manner of solving the problem",
            "singular manner of solving the problem",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,"In flowchart, diamond shaped symbol is used to represent",
            (R.drawable.flowchart),
            "statement box",
            "error box",
            "if-statement box",
            "decision box",
            3
        )

        questionsList.add(que7)

        val que8 = Question(
            8,"Terminal symbol in a flowchart indicates the",
            (R.drawable.flowchart),
            "processing",
            "input and output",
            "end",
            "decision",
            3
        )

        questionsList.add(que8)

        val que9 = Question(
            9,"Which of the following symbols in a flowchart is used to indicate all arithmetic operations like addition?",
            (R.drawable.flowchart),
            "processing",
            "input and output",
            "decision",
            "connector",
            1
        )

        questionsList.add(que9)

        val que10 = Question(
            10,"Which of these is a characteristic of an algorithm?",
            (R.drawable.flowchart),
            "effective",
            "logical",
            "expedient",
            "source",
            1
        )

        questionsList.add(que10)


        val que11 = Question(
            11,"Which symbol is used to represent output in a flowchart?",
            (R.drawable.flowchart),
            "square",
            "circle",
            "parallelogram",
            "triangle",
            3
        )

        questionsList.add(que11)

        val que12 = Question(
            12,"Algorithm is a",
            (R.drawable.flowchart),
            "systematic manner of solving a problem",
            "social manner of solving a problem",
            "singular manner of solving a problem",
            "sensational manner of a solving a problem",
            1
        )

        questionsList.add(que12)

        val que13 = Question(
            13,"What is the function of the image above in a flowchart?",
            (R.drawable.flowchart_parallel),
            "start",
            "input",
            "end",
            "process",
            2
        )

        questionsList.add(que13)

        val que14 = Question(
            14,"The symbol used to connect two symbols is called",
            (R.drawable.flowchart),
            "arrow",
            "line",
            "curve",
            "rope",
            1
        )

        questionsList.add(que14)

        val que15 = Question(
            15,"The shape above signifies what function in a flowchart?",
            (R.drawable.flowchart_oval),
            "start/end",
            "input/output",
            "sing/dance",
            "clap/jump",
            1
        )

        questionsList.add(que15)

        val que16 = Question(
            16,"An algorithm is written with",
            (R.drawable.flowchart),
            "sign language",
            "human language",
            "animal language",
            "singing language",
            2
        )

        questionsList.add(que16)

        val que17 = Question(
            17,"In a flowchart, decision is made with which symbol?",
            (R.drawable.flowchart),
            "Oval",
            "Parallelogram",
            "Rectangle",
            "Diamond",
            4
        )

        questionsList.add(que17)

        val que18 = Question(
            18,"The unambiguous characteristics of an algorithm means that it should be easily",
            (R.drawable.flowchart),
            "understood",
            "drawn",
            "jumped",
            "dictated",
            1
        )

        questionsList.add(que18)

        val que19 = Question(
            19,"What symbol terminates a flowchart?",
            (R.drawable.flowchart),
            "Diamond",
            "Oval",
            "Parallelogram",
            "Square",
            2
        )

        questionsList.add(que19)

        val que20 = Question(
            20,"A good algorithm must always have",
            (R.drawable.flowchart),
            "throughput and singput",
            "high put and low put",
            "sing put and dance put",
            "input and out put",
            4
        )

        questionsList.add(que20)

        val que21 = Question(
            21,"Flowchart refers to the",
            (R.drawable.flowchart),
            "input representation",
            "processing representation",
            "pictorial representation",
            "decision representation",
            3
        )

        questionsList.add(que21)

        val que22 = Question(
            22,"The shape above signifies what function in a flowchart",
            (R.drawable.decision),
            "start/end",
            "input/output",
            "decision making",
            "end",
            3
        )

        questionsList.add(que22)

        val que23 = Question(
            23,"The shape above signifies what function in a flowchart?",
            (R.drawable.connectors),
            "connector",
            "input/output",
            "decision making",
            "end",
            1
        )

        questionsList.add(que23)

        val que24 = Question(
            24,"An algorithm uses mainly ____ to describe the steps",
            (R.drawable.flowchart),
            "arrows",
            "words",
            "shapes",
            "diagram",
            2
        )

        questionsList.add(que24)


        return questionsList
    }

}



