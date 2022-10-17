package com.example.kotlinquizapp

object Constants
{

    const val USER_NAME:String="username"
    const val TOTAL_QUESTIONS:String="total questions"
    const val CORRECT_ANSWER:String="correct answer"

    fun getQuestion():ArrayList<Question>
    {
        val questionList=ArrayList<Question>()

        val que1=Question(1,"What country does this flag belong to?",
        R.drawable.flag_india,"India","Australia",
        "America","Chine",1)
        questionList.add(que1)


        val que2=Question(2,"What country does this flag belong to?",
            R.drawable.flag_australia,"India","Australia",
            "America","Chine",2)
        questionList.add(que2)


        val que3=Question(3,"What country does this flag belong to?",
            R.drawable.flag_america,"India","Australia",
            "America","Chine",3)
        questionList.add(que3)


        val que4=Question(4,"What country does this flag belong to?",
            R.drawable.flag_china,"India","Australia",
            "America","Chine",4)
        questionList.add(que4)


        val que5=Question(5,"What country does this flag belong to?",
            R.drawable.flag_japan,"Australia","India",
            "Japan","Chine",3)
        questionList.add(que5)


        val que6=Question(6,"What country does this flag belong to?",
            R.drawable.flag_taiwan,"America","Australia",
            "India","Taiwan",4)
        questionList.add(que6)


        val que7=Question(7,"What country does this flag belong to?",
            R.drawable.flag_pakistan,"Pakistan","Australia",
            "America","Chine",1)
        questionList.add(que7)

        val que8=Question(8,"What country does this flag belong to?",
            R.drawable.flag_london,"India","London",
            "Russia","Chine",2)
        questionList.add(que8)

        val que9=Question(9,"What country does this flag belong to?",
            R.drawable.flag_russia,"India","Russia",
            "America","Chine",2)
        questionList.add(que9)

        val que10=Question(10,"What country does this flag belong to?",
            R.drawable.flag_sri_lanka,"Sri_Lanka","Australia",
            "America","India",1)
        questionList.add(que10)

        return questionList
    }


}