package com.almiladurukavak.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.almiladurukavak.quizapp.databinding.ActivitySelectCategoryBinding

class SelectCategoryActivity : AppCompatActivity() {


    lateinit var spaceButton: Button
    lateinit var foodButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_category)

        spaceButton=findViewById(R.id.spaceButton) as Button
        foodButton=findViewById(R.id.foodButton) as Button


        spaceButton.setOnClickListener{


            var intent= Intent(this,MainActivity::class.java)
            intent.putExtra("${localData.category}","space")
            startActivity(intent)
            finish()


        }

        foodButton.setOnClickListener{



            var intent= Intent(this,MainActivity::class.java)
            intent.putExtra("${localData.category}","food")
            startActivity(intent)
            finish()


        }


    }


}