package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Matriks3x3 : AppCompatActivity() {

    companion object
    {
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matriks3x3)

        val moveMatriks3x3: TextView = findViewById(R.id.dataMatriks3x3)
        val name = intent.getStringExtra(EXTRA_NAME)
        moveMatriks3x3.text = name
    }
}
