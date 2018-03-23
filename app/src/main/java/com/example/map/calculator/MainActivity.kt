package com.example.map.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), CalculatorView {

    lateinit var presenter: CalculatorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CalculatorPresenter(this)
        presenter.start()
    }

    override fun setDisplayValue(msg: String) {
        calcualtorTextView.text = msg
    }

    override fun setAnswerValue(ans: String) {
        answerTextView.text = ans
    }

    fun onDigitClicked(view: View) {
        val digitButton: Button = view as Button
        presenter.onDigitClicked(digitButton.text.toString().toInt())
    }

    fun onOperationClicked(view: View) {
        val operationButton: Button = view as Button
        presenter.onOperationClicked(operationButton.text.toString())
    }

    fun onAnsClicked(view: View) {
        presenter.onAnsClicked()
    }

    fun onClearClicked(view: View) {
        presenter.onClearClicked()
    }
}
