package com.almiladurukavak.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    lateinit var congtext: TextView
    lateinit var scoreText:TextView
    lateinit var buttonComplete: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        congtext=findViewById(R.id.congName) as TextView
        scoreText=findViewById(R.id.score) as TextView
        buttonComplete=findViewById(R.id.button_complete)

        val userName=intent.getStringExtra(localData.username)
        val score=intent.getStringExtra(localData.score)
        val totalQuestions= intent.getStringExtra("total size")

        congtext.text="Congratulations ${userName} !!"
        scoreText.text="${score}/${totalQuestions}"
        buttonComplete.setOnClickListener{

            startActivity(Intent(this,MainActivity::class.java))

        }




    }
}