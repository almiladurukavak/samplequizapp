package com.almiladurukavak.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import kotlinx.android.synthetic.main.activity_question.*
import org.w3c.dom.Text

class QuestionActivity : AppCompatActivity() {


    private var userName: String? = null
    private var category: String? = null

    private var score: Int = 0

    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionModel>? = null

    private var selectedOption: Int = 0
    lateinit var firstOption: TextView
    lateinit var secondOption: TextView
    lateinit var thirdOption: TextView
    lateinit var submitButton: Button
    lateinit var progressBar: ProgressBar
    lateinit var progressText: TextView

    lateinit var questionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        firstOption = findViewById(R.id.opt1) as TextView
        secondOption = findViewById(R.id.opt2) as TextView
        thirdOption = findViewById(R.id.opt3) as TextView
        submitButton = findViewById(R.id.submitButton) as Button
        progressBar = findViewById(R.id.progress_bar) as ProgressBar
        progressText = findViewById(R.id.progress_text) as TextView
        questionText = findViewById(R.id.question_text) as TextView



        userName = intent.getStringExtra(localData.username)
        category = intent.getStringExtra(localData.category)


        //set space question or food question
        // based on selected category
        if (category == "food") {
            questionList = localData.getFoodQuestion()

        } else if (category == "space") {

            questionList = localData.getFoodQuestion()

        }

        setQuestion()

        firstOption.setOnClickListener {

            selectedOptionStyle(firstOption, 1)

        }
        secondOption.setOnClickListener {

            selectedOptionStyle(secondOption, 2)

        }
        thirdOption.setOnClickListener {

            selectedOptionStyle(thirdOption, 3)

        }

        submitButton.setOnClickListener {

            if (selectedOption != 0) {

                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correctAnswers) {

                    setColor(selectedOption, R.drawable.wrong_answer_opt)

                } else {
                    score++
                }

                setColor(question.correctAnswers, R.drawable.correct_question_opt)
                if (currentPosition == questionList!!.size)
                    submitButton.text = "Completed"
                else
                    submitButton.text = "Next Question"

            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {

                        setQuestion()

                    }
                    else -> {

                        var intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(localData.username, userName.toString())
                        intent.putExtra(localData.score, score.toString())
                        intent.putExtra("total size", questionList!!.size.toString())

                        startActivity(intent)
                        finish()

                    }

                }

            }
            selectedOption = 0
        }


    }

    private fun selectedOptionStyle(firstOption: TextView, i: Int) {

        setOptionStyle()
        selectedOption = i
        firstOption.background = ContextCompat.getDrawable(this, R.drawable.selected_question_opt)
        firstOption.typeface = Typeface.DEFAULT_BOLD
        firstOption.setTextColor(Color.parseColor("#000000"))

    }

    fun setOptionStyle() {

        var optionList: ArrayList<TextView> = arrayListOf()

            optionList.add(0, firstOption)

            optionList.add(1, secondOption)

            optionList.add(2, thirdOption)


        val question = questionList!![currentPosition - 1]

        for (opt in optionList) {

            opt.setTextColor(Color.parseColor("#424040"))

            if (question.firstOpt!=""){
                firstOption.background = ContextCompat.getDrawable(applicationContext, R.drawable.default_question_opt)

            }else{

                firstOption.background = ContextCompat.getDrawable(applicationContext, R.drawable.no_opt_style)

            }
            if (question.secondOpt!=""){
                secondOption.background = ContextCompat.getDrawable(applicationContext, R.drawable.default_question_opt)

            }else{

                secondOption.background = ContextCompat.getDrawable(applicationContext, R.drawable.no_opt_style)

            }
            if (question.thirdOpt!=""){
                thirdOption.background = ContextCompat.getDrawable(applicationContext, R.drawable.default_question_opt)

            }else{

                thirdOption.background = ContextCompat.getDrawable(applicationContext, R.drawable.no_opt_style)

            }
            opt.typeface = Typeface.DEFAULT


        }


    }

    private fun setColor(correctAnswers: Int, correctQuestionOpt: Int) {

        when (correctAnswers) {

            1 -> {
                firstOption.background = ContextCompat.getDrawable(this, correctQuestionOpt)
            }
            2 -> {
                secondOption.background = ContextCompat.getDrawable(this, correctQuestionOpt)
            }
            3 -> {
                thirdOption.background = ContextCompat.getDrawable(this, correctQuestionOpt)
            }
        }


    }

    private fun setQuestion() {


        val question = questionList!![currentPosition - 1]


        setOptionStyle()

        progressBar.progress = currentPosition
        progressBar.max = questionList!!.size
        progressText.text = "${currentPosition}" + "/" + "${questionList!!.size}"
        questionText.text = question.question

        firstOption.text = question.firstOpt
        secondOption.text = question.secondOpt
        thirdOption.text = question.thirdOpt

    }


}