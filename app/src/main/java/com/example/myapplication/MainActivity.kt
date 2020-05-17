package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMatriks2x2: Button = findViewById(R.id.btn_matriks2x2)
        val btnMatriks3x3: Button = findViewById(R.id.btn_matriks3x3)
        val btnMatriks4x4: Button = findViewById(R.id.btn_matriks4x4)

        btnMatriks2x2.setOnClickListener(this)
        btnMatriks3x3.setOnClickListener(this)
        btnMatriks4x4.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id)
        {
            R.id.btn_matriks2x2 -> {
                val moveMatriks2x2 = Intent(this@MainActivity, Matriks2x2::class.java)
                moveMatriks2x2.putExtra(Matriks2x2.EXTRA_NAME, "Matriks Solutions for 2x2")
                startActivity(moveMatriks2x2)
            }
            R.id.btn_matriks3x3 -> {
                val moveMatriks3x3 = Intent(this@MainActivity, Matriks3x3::class.java)
                moveMatriks3x3.putExtra(Matriks3x3.EXTRA_NAME,"Matriks Solutions for 3x3")
                startActivity(moveMatriks3x3)
            }
            R.id.btn_matriks4x4 -> {
                val phoneNumber = 0
                val moveDialNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(moveDialNumber)
            }
        }
    }
}
