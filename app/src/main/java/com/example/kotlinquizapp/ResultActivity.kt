package com.example.kotlinquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userNm=intent.getStringExtra(Constants.USER_NAME)
        tv_name.text=userNm
        val totalQuestion=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer=intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        score.text="Your Score is $correctAnswer out of $totalQuestion"

        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}