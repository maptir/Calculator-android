package com.example.map.calculator


/**
 * Created by map on 3/23/18.
 */
class CalculatorPresenter(val view: CalculatorView) {

    var msg: String = ""
    var ans: Int = 0

    fun start() {
        clear()
    }

    fun calculate() {
        var split = msg.split(" ")
        var currentNumber: Int = if(msg.isBlank()) 0 else split[0].toInt()
        var operand: String = ""
        if(split.size == 1)
            return
        for(i in 1 until split.size) {
            val item: String = split[i]
            if(item.toIntOrNull() == null){
                operand = item
            } else {
                currentNumber = perform(currentNumber, operand, item.toInt())
            }
        }
        ans = currentNumber;
    }

    fun perform(reg1: Int, operand: String, reg2: Int): Int{
        if(operand == "+")
            return reg1 + reg2
        if(operand == "-")
            return reg1 - reg2
        if(operand == "*")
            return reg1 * reg2
        if(operand == "/")
            return reg1 / reg2
        return -1
    }

    fun updateCalculator() {
        calculate()
        view.setDisplayValue(msg)
        view.setAnswerValue(ans.toString())
    }

    fun clear() {
        msg = ""
        updateCalculator()
    }

    fun onDigitClicked(digit: Int) {
        msg += digit
        updateCalculator()
    }

    fun onOperationClicked(operand: String) {
        if(msg.isNotEmpty()) {
            msg += " " + operand + " "
            updateCalculator()
        }
    }

    fun onAnsClicked() {
        calculate()
        msg = ans.toString()
        view.setDisplayValue(ans.toString())
        view.setAnswerValue("")
    }

    fun onClearClicked() {
        clear()
        updateCalculator()
    }

}