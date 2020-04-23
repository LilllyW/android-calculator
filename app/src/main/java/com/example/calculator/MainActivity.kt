package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.calculator.Adapter.ButtonAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_button_list.*
import net.objecthunter.exp4j.ExpressionBuilder
import androidx.core.text.isDigitsOnly as isDigitsOnly1
import kotlin.text.substring

class MainActivity : AppCompatActivity() {
    var buttonList : ArrayList<String> = arrayListOf("7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rlResult.layoutManager = GridLayoutManager(this, 4)
        rlResult.adapter = ButtonAdapter(buttonList)
    }

    fun onClick(sender: View) {
        when (sender.tag){
            "C" -> txtResult.text = ""
            "÷" -> txtResult.append("/")
            "x" -> {
                txtResult.append("*")
            }
            "=" -> onCalculate()
//            else -> txtResult.text = txtResult.text.toString() + sender.tag
            else -> txtResult.append(sender.tag.toString())
        }
    }//onClick button "btnResult" run this function, then show on the TextView "txtResult"

    private fun onCalculate(){
        val expression = ExpressionBuilder(txtResult.text.toString()).build()
        txtResult.text = expression.evaluate().toString()
    }
}
