package com.example.kotlinquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private  var mCurrentPosition:Int =1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswer:Int=0
    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName=intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList=Constants.getQuestion()
       // Log.i("Questions Size","${questionList.size}")

        setQuestion()

        tv_op_one.setOnClickListener(this)
        tv_op_two.setOnClickListener(this)
        tv_op_three.setOnClickListener(this)
        tv_op_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)
    }
    private fun setQuestion()
    {
        //mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition -1]

        defaultOptionView()

        if (mCurrentPosition==mQuestionsList!!.size)
        {
            btn_submit.text="FINISH"
        }
        else
        {
            btn_submit.text="SUBMIT"
        }

        progressBar.progress=mCurrentPosition
        tv_Progress.text="$mCurrentPosition"+"/"+progressBar.max

        tv_question.text=question!!.question
        iv_img.setImageResource(question.image)

        tv_op_one.text=question.optionOne
        tv_op_two.text=question.optionTwo
        tv_op_three.text=question.optionThree
        tv_op_four.text=question.optionFour
    }
    private fun defaultOptionView()
    {
        val options=ArrayList<TextView>()
        options.add(0,tv_op_one)
        options.add(1,tv_op_two)
        options.add(2,tv_op_three)
        options.add(3,tv_op_four)

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.option_border_bg
            )
        }
    }

    override fun onClick(v: View?)
    {
        when(v?.id)
        {
            R.id.tv_op_one->
            {
                selectedOptionView(tv_op_one,1)
            }
            R.id.tv_op_two->
            {
                selectedOptionView(tv_op_two,2)
            }
            R.id.tv_op_three->
            {
                selectedOptionView(tv_op_three,3)
            }
            R.id.tv_op_four->
            {
                selectedOptionView(tv_op_four,4)
            }
            R.id.btn_submit->
            {
                if(mSelectedOptionPosition==0)
                {
                    mCurrentPosition++
                    when
                    {
                        mCurrentPosition<=mQuestionsList!!.size->
                        {
                            setQuestion()
                        }
                        else->
                        {
                            //Toast.makeText(this,"You have successfully completed the Quiz ",Toast.LENGTH_SHORT).show()
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                            startActivity(intent)
                        }


                    }


                }
                else
                {
                    val question=mQuestionsList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer!=mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition,R.drawable.incorrect_op_bg)
                    }
                    else
                    {
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_op_border_bg)

                    if (mCurrentPosition==mQuestionsList!!.size)
                    {
                        btn_submit.text="FINISH"
                    }
                    else
                    {
                        btn_submit.text="Go To Next Question"
                    }
                    mSelectedOptionPosition=0
                }

            }


        }


    }
    private fun answerView(answer: Int,drawableView: Int)
    {
        when(answer)
        {
            1->
            {
                tv_op_one.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->
            {
                tv_op_two.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->
            {
                tv_op_three.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->
            {
                tv_op_four.background=ContextCompat.getDrawable(this,drawableView)
            }

        }

    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int)
    {
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_op_bg)
    }


}