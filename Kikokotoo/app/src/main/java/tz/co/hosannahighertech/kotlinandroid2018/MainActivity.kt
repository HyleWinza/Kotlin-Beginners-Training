package tz.co.hosannahighertech.kotlinandroid2018

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tz.co.hosannahighertech.kotlinandroid2018.core.Calculator

class MainActivity(private val calculator: Calculator = Calculator()) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI()
    {
        /**
         * Kotlin allows you to reference the views by its IDs
         * Make sure that you import the synthetic which is powered
         * by Kotlin extensions plugin
         * see import kotlinx.android.synthetic.main.activity_main.*
         */

        one.setOnClickListener{
            screen.append("1")
            calculator.append("1")
        }

        two.setOnClickListener{
            screen.append("2")
            calculator.append("2")
        }

        three.setOnClickListener{
            screen.append("3")
            calculator.append("3")
        }

        four.setOnClickListener{
            screen.append("4")
            calculator.append("4")
        }

        five.setOnClickListener{
            screen.append("5")
            calculator.append("5")
        }

        six.setOnClickListener{
            screen.append("6")
            calculator.append("6")
        }

        seven.setOnClickListener{
            screen.append("7")
            calculator.append("7")
        }

        eight.setOnClickListener{
            screen.append("8")
            calculator.append("8")
        }

        nine.setOnClickListener{
            screen.append("9")
            calculator.append("9")
        }

        zero.setOnClickListener{
            screen.append("0")
            calculator.append("0")
        }

        plus.setOnClickListener{
            screen.append("+")
            calculator.operator("+")
        }

        minus.setOnClickListener{
            screen.append("-")
            calculator.operator("-")
        }

        division.setOnClickListener{
            screen.append("/")
            calculator.operator("/")
        }

        multiplication.setOnClickListener{
            screen.append("x")
            calculator.operator("x")
        }

        dot.setOnClickListener{
            screen.append(".")
            calculator.append(".")
        }

        equals.setOnClickListener{
            calculator.operator("=")
            val result: String = calculator.currState().toString()
            screen.text = result
        }

        clear.setOnClickListener{
            screen.text = ""
            calculator.clear()
        }

        delete.setOnClickListener{
            var screenText: String = screen.text.toString()
            var drops = 1

            if(screenText.substringAfter('.') == "0")
                drops = 3

            screenText = screenText.dropLast(drops)
            screen.text = screenText

            calculator.delete()
        }
    }
}
