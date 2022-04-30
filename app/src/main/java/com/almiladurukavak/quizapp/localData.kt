package com.almiladurukavak.quizapp

object localData {

    const val username:String= "inputUsername"
    const val score:String="score"

    const val category:String="category"

    fun getSpaceQuestion():ArrayList<QuestionModel>{

        var queque:ArrayList<QuestionModel> = arrayListOf()


        var firstQuestion= QuestionModel(
            1,
            "About how many stars are in the Milky Way?",
            "50-100 billion",
            "150-250 billion" ,
                    "350-550 billion",
            2


        )


        var secondQuestion= QuestionModel(
            2,
            "Which planet is closest to Earth?",
            "Mercury",
            "Venus",
            "Mars",
            1

        )

        var thirdQuestion= QuestionModel(
            3,
            "What is the largest planet in our solar system?",
            "Saturn",
            "Venus",
            "Jupiter",
            3

        )
        var fourthQuestion= QuestionModel(
            4,
            "Which planet has a day that lasts almost eight months on Earth?",
            "Venus",
            "Mercury",
            "Pluton",
            1
        )

        var fifthQuestion= QuestionModel(
            5,
            "What was the first animal to go into orbit?",
            "A dog",
            "A cat",
            "A frog",
            1
        )
        var sixthQuestion= QuestionModel(
            6,
            "How many Earths can fit inside the sun?",
            "0.7 million",
            "1.0 million",
            "1.3 million",
            3
        )

        queque.add(firstQuestion)
        queque.add(secondQuestion)
        queque.add(thirdQuestion)
        queque.add(fourthQuestion)
        queque.add(fifthQuestion)
        queque.add(sixthQuestion)
        return queque


    }
    fun getFoodQuestion():ArrayList<QuestionModel>{

        var queque:ArrayList<QuestionModel> = arrayListOf()


        var firstQuestion= QuestionModel(
            1,
            "What food serves as the base for guacamole?",
            "Zucchini",
            "Cucumber" ,
            "Avocado",
            3


        )


        var secondQuestion= QuestionModel(
            2,
            "What food is the most ordered in America?",
            "Fried chicken",
            "Hamburger",
            "Pizza",
            1

        )

        var thirdQuestion= QuestionModel(
            3,
            "What is the world record for number of hotdogs eaten in one sitting?",
            "56",
            "74",
            "82",
            2

        )
        var fourthQuestion= QuestionModel(
            4,
            "What contains more sugar, strawberries or lemons?",
            "Lemons",
            "Strawberries",
            "",
            1
        )

        var fifthQuestion= QuestionModel(
            5,
            "Can you name the largest chocolate manufacturer in the United States?",
            "Hershey’s",
            " Willy Wonka",
            "",
            1
        )

        queque.add(firstQuestion)
        queque.add(secondQuestion)
        queque.add(thirdQuestion)
        queque.add(fourthQuestion)
        queque.add(fifthQuestion)
        return queque


    }


}