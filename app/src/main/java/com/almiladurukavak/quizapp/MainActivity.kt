package com.almiladurukavak.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val nextButton:Button=findViewById(R.id.nextButton)
        val inputUserName:AppCompatEditText=findViewById(R.id.inputUserName)
        val category=intent.getStringExtra(localData.category)



        nextButton.setOnClickListener{

            if (inputUserName.text.toString().isEmpty()){

                Toast.makeText(this,"Enter your username",Toast.LENGTH_SHORT).show()


            }else{

                var intent= Intent(this,QuestionActivity::class.java)
                intent.putExtra("${localData.username}",inputUserName.text.toString())
                intent.putExtra("category",category)
                startActivity(intent)
                finish()

            }

        }

    }
}