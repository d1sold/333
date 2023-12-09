package com.example.a333

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.annotation.SuppressLint
import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    fun setTextFields(str: String) {
        math_operation.append(str)
    }

    private lateinit var  math_operation: EditText
    private lateinit var  result_text: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        math_operation = findViewById(R.id.math_operation)
        result_text = findViewById(R.id.result_text)

        val btn0 = findViewById<TextView>(R.id.btn_0)
        val btn1 = findViewById<TextView>(R.id.btn_1)
        val btn2 = findViewById<TextView>(R.id.btn_2)
        val btn3 = findViewById<TextView>(R.id.btn_3)
        val btn4 = findViewById<TextView>(R.id.btn_4)
        val btn5 = findViewById<TextView>(R.id.btn_5)
        val btn6 = findViewById<TextView>(R.id.btn_6)
        val btn7 = findViewById<TextView>(R.id.btn_7)
        val btn8 = findViewById<TextView>(R.id.btn_8)
        val btn9 = findViewById<TextView>(R.id.btn_9)
        val btnCE = findViewById<TextView>(R.id.btnCE)
        val btnMinus = findViewById<TextView>(R.id.minus_btn)
        val btnPlus = findViewById<TextView>(R.id.plus_btn)
        val btnMult = findViewById<TextView>(R.id.mult_btn)
        val btnDevision = findViewById<TextView>(R.id.devision_btn)
        val btnClear = findViewById<TextView>(R.id.clear_btn)
        val btnSkobka1 = findViewById<TextView>(R.id.skobka1_btn)
        val btnSkobka2 = findViewById<TextView>(R.id.skobka2_btn)
        val btnRavno = findViewById<TextView>(R.id.ravno_btn)


        btn0.setOnClickListener { setTextFields("0") }
        btn1.setOnClickListener { setTextFields("1") }
        btn2.setOnClickListener { setTextFields("2") }
        btn3.setOnClickListener { setTextFields("3") }
        btn4.setOnClickListener { setTextFields("4") }
        btn5.setOnClickListener { setTextFields("5") }
        btn6.setOnClickListener { setTextFields("6") }
        btn7.setOnClickListener { setTextFields("7") }
        btn8.setOnClickListener { setTextFields("8") }
        btn9.setOnClickListener { setTextFields("9") }
        btnMinus.setOnClickListener { setTextFields("-") }
        btnPlus.setOnClickListener { setTextFields("+") }
        btnMult.setOnClickListener { setTextFields("*") }
        btnDevision.setOnClickListener { setTextFields("/") }
        btnSkobka1.setOnClickListener { setTextFields("(") }
        btnSkobka2.setOnClickListener { setTextFields(")") }

        btnCE.setOnClickListener {
            math_operation.text.clear()
            result_text.text.clear()
        }

        btnClear.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty()) {
               math_operation.setText(str.substring(0, str.length - 1))
            }
            result_text.text.clear()
        }

        btnRavno.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble()) {
                    result_text.text = longRes.toString()
                } else {
                    result_text.text = result.toString()
                }

            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }
}