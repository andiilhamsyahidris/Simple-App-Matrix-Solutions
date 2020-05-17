package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PaperResult : AppCompatActivity() {

    companion object
    {
        const val answer = "answer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_determinan_matriks2x2)

        val answerSumMatriks2x2: TextView = findViewById(R.id.answerDetMatriks2x2)
        val answer = intent.getStringExtra(answer)
        answerSumMatriks2x2.text = answer
    }
}
