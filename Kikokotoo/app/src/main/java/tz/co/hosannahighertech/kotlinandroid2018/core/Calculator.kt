package tz.co.hosannahighertech.kotlinandroid2018.core

class Calculator {
    private var currentNumber: String = ""
    private var currentState: Double = 0.0
    private var currentOperation = ""

    private fun results()
    {
        when(currentOperation)
        {
            "+" -> {
                currentState = currentState.plus(currentNumber.toDouble())
            }
            "-" -> {
                currentState = currentState.minus(currentNumber.toDouble())
            }
            "x" -> {
                currentState = currentState.times(currentNumber.toDouble())
            }
            "/" -> {
                currentState = currentState.div(currentNumber.toDouble())
            }
        }
    }

    fun currState() = currentState

    fun operator(op:String)
    {
        if(currentOperation.isEmpty())
        {
            if (currentNumber.isNotEmpty())
                currentState = currentNumber.toDouble()
        }
        else
        {
            results()
        }
        currentOperation = op
        currentNumber = ""
    }

    fun  append(text:String) {
            currentNumber += text
    }

    fun  delete() {
        if(currentNumber.isEmpty())
        {
            var drops = 1
            if(currentState.toString().substringAfter('.') == "0")
                drops = 3

            currentState = currentState.toString().dropLast(drops).toDouble()
        }
        else
        {
            currentNumber = currentNumber.dropLast(1)
        }
    }

    fun  clear() {
        currentNumber = ""
        currentOperation = ""
        currentState = 0.00
    }
}