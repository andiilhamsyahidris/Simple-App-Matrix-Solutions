package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

@Suppress("CAST_NEVER_SUCCEEDS")
class Matriks2x2 : AppCompatActivity(), View.OnClickListener{

    private lateinit var b1k1: EditText
    private lateinit var b1k2: EditText
    private lateinit var b2k1: EditText
    private lateinit var b2k2: EditText

    companion object
    {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matriks2x2)

        val wordMatriks2x2: TextView = findViewById(R.id.dataMatriks2x2)
        val word = intent.getStringExtra(EXTRA_NAME)
        wordMatriks2x2.text = word

        val btnDeterminan: Button = findViewById(R.id.determinanMatriks2x2)
        val btnInvers: Button = findViewById(R.id.inversMatriks2x2)
        b1k1 = findViewById(R.id.matriks2x2b1k1)
        b1k2 = findViewById(R.id.matriks2x2b1k2)
        b2k1 = findViewById(R.id.matriks2x2b2k1)
        b2k2 = findViewById(R.id.matriks2x2b2k2)
        btnDeterminan.setOnClickListener(this)
        btnInvers.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id)
        {
            R.id.determinanMatriks2x2 -> {
                val moveDeterminanMatriks2x2 = Intent(this@Matriks2x2, PaperResult::class.java)
                val inputB1k1 = b1k1.text.toString().trim()
                val inputB1k2 = b1k2.text.toString().trim()
                val inputB2k1 = b2k1.text.toString().trim()
                val inputB2k2 = b2k2.text.toString().trim()
                var isEmptyField = false

                when {
                    inputB1k1.isEmpty() -> {
                        isEmptyField = true
                        b1k1.error = "Field tidak boleh kosong"
                    }
                    inputB1k2.isEmpty() -> {
                        isEmptyField = true
                        b1k2.error = "Field tidak boleh kosong"
                    }
                    inputB2k1.isEmpty() -> {
                        isEmptyField = true
                        b2k1.error = "Field tidak boleh kosong"
                    }
                    inputB2k2.isEmpty() -> {
                        isEmptyField = true
                        b2k2.error = "Field tidak boleh kosong"
                    }
                }
                val matriks2x2b1k1 = toInt(inputB1k1)
                val matriks2x2b1k2 = toInt(inputB1k2)
                val matriks2x2b2k1 = toInt(inputB2k1)
                val matriks2x2b2k2 = toInt(inputB2k2)

                if (!isEmptyField)
                {
                    val answerDeterminan = (matriks2x2b1k1 as Int * matriks2x2b2k2 as Int) - (matriks2x2b2k1 as Int * matriks2x2b1k2 as Int)
                    moveDeterminanMatriks2x2.putExtra(PaperResult.answer, """
                    |$matriks2x2b1k1 $matriks2x2b1k2|       =   ($matriks2x2b1k1 x $matriks2x2b2k2) - ($matriks2x2b2k1 x $matriks2x2b1k2)
                    |$matriks2x2b2k1 $matriks2x2b2k2|     
                                  =   $answerDeterminan
                """.trimIndent())
                    startActivity(moveDeterminanMatriks2x2)
                }
            }
            R.id.inversMatriks2x2 -> {
                val moveInversMatriks2x2 = Intent(this@Matriks2x2, PaperResult::class.java)
                val inputB1k1 = b1k1.text.toString().trim()
                val inputB1k2 = b1k2.text.toString().trim()
                val inputB2k1 = b2k1.text.toString().trim()
                val inputB2k2 = b2k2.text.toString().trim()
                var isEmptyField = false

                when {
                    inputB1k1.isEmpty() -> {
                        isEmptyField = true
                        b1k1.error = "Field tidak boleh kosong"
                    }
                    inputB1k2.isEmpty() -> {
                        isEmptyField = true
                        b1k2.error = "Field tidak boleh kosong"
                    }
                    inputB2k1.isEmpty() -> {
                        isEmptyField = true
                        b2k1.error = "Field tidak boleh kosong"
                    }
                    inputB2k2.isEmpty() -> {
                        isEmptyField = true
                        b2k2.error = "Field tidak boleh kosong"
                    }
                }
                var matriks2x2b1k1 = toInt(inputB1k1)
                var matriks2x2b1k2 = toInt(inputB1k2)
                var matriks2x2b2k1 = toInt(inputB2k1)
                var matriks2x2b2k2 = toInt(inputB2k2)

                if (!isEmptyField)
                {
                    var answerDeterminan = (matriks2x2b1k1 as Int * matriks2x2b2k2 as Int) - (matriks2x2b2k1 as Int * matriks2x2b1k2 as Int)

                    when { // Pengkondisian digunakan untuk mengecek apakah bilangan yang terdapat di matriks itu dapat disederhanakan atau tidak
                        /*
                        Jika matriks pada baris 2 kolom 2 lebih kecil dari determinan
                        Misalnya = (2/3), maka bilangan itu dapat disederhanakan
                         */
                        matriks2x2b2k2 < answerDeterminan -> {
                            var number = 0
                            while (true)
                            {
                                number++
                                if (matriks2x2b2k2 % number == 0 && answerDeterminan % number == 0)
                                {
                                    matriks2x2b2k2 /= number
                                    answerDeterminan /= number
                                }
                                break
                            }
                        }
                        /*
                        Jika lebih besar dari determinan
                        misal = (4/2), maka bilangan itu dapat langsung dibagi.
                        -- Begitupun dengan kondisi di bawahnya --
                         */
                        matriks2x2b2k2 > answerDeterminan -> {
                            if (matriks2x2b2k2 % answerDeterminan == 0)
                            {
                                matriks2x2b2k2 /= answerDeterminan
                            }
                        }
                        matriks2x2b1k2 < answerDeterminan -> {
                            var number = 0
                            while (true)
                            {
                                number++
                                if (matriks2x2b1k2 % number == 0 && answerDeterminan % number == 0)
                                {
                                    matriks2x2b1k2 /= number
                                    answerDeterminan /= number
                                }
                                break
                            }
                        }
                        matriks2x2b1k2 > answerDeterminan -> {
                            if (matriks2x2b1k2 % answerDeterminan == 0)
                            {
                                matriks2x2b1k2 /= answerDeterminan
                            }
                        }
                        matriks2x2b2k1 < answerDeterminan -> {
                            var number = 0
                            while (true)
                            {
                                number++
                                if (matriks2x2b2k1 % number == 0 && answerDeterminan % number == 0)
                                {
                                    matriks2x2b2k1 /= number
                                    answerDeterminan /= number
                                }
                                break
                            }
                        }
                        matriks2x2b2k1 > answerDeterminan -> {
                            if (matriks2x2b2k1 % answerDeterminan == 0)
                            {
                                matriks2x2b2k1 /= answerDeterminan
                            }
                        }
                        matriks2x2b1k1 < answerDeterminan -> {
                            var number = 0
                            while (true)
                            {
                                number++
                                if (matriks2x2b1k1 % number == 0 && answerDeterminan % number == 0)
                                {
                                    matriks2x2b1k1 /= number
                                    answerDeterminan /= number
                                }
                                break
                            }
                        }
                        matriks2x2b1k1 > answerDeterminan -> {
                            if (matriks2x2b1k1 % answerDeterminan == 0)
                            {
                                matriks2x2b1k1 /= answerDeterminan
                            }
                        }
                    }
                    moveInversMatriks2x2.putExtra(PaperResult.answer, """
                    |$matriks2x2b1k1 $matriks2x2b1k2|   =   |$matriks2x2b2k2 -$matriks2x2b1k2|
                    |$matriks2x2b2k1 $matriks2x2b2k2|        |-$matriks2x2b2k1 $matriks2x2b1k1|
                    
                    Det = ($matriks2x2b1k1 x $matriks2x2b2k2) - ($matriks2x2b2k1 x $matriks2x2b1k2)
                           = $answerDeterminan
                              
                    Invers    =  1/$answerDeterminan x  |$matriks2x2b2k2 -$matriks2x2b1k2|
                                                    |-$matriks2x2b2k1 $matriks2x2b1k1|
                                  = |$matriks2x2b2k2/$answerDeterminan   -$matriks2x2b1k2/$answerDeterminan|
                                     |-$matriks2x2b2k1/$answerDeterminan  $matriks2x2b1k1/$answerDeterminan |
                """.trimIndent())
                    startActivity(moveInversMatriks2x2)
                }
            }
        }
    }

    private fun toInt(str: String): Int?
    {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }
}

