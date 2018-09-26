fun main (args : Array<String>)
{
    val today = 4

    when(today)
    {
        1 -> {
            println("Today is Monday")
            //...
            // other codes
        }
        2 -> println("It is Tuesday")
        else -> println("Thank God it is Friday (TGIF)")
    }

    //is today a weekend or not
    when(today)
    {
        in 1..5 -> println("It is a week day")
        else -> println("It is a weekend!")
    }

    //replace long if else
    var number = 20
    when {
        number < 0 -> println("$number is less than zero")
        number % 2 != 0 -> println("$number is Odd")
        number > 1000 -> println("$number is greater than 1000")
        else -> println("Yay! no match found!")
    }

    //smart casts
    //val x : Any = 10
    val x : Any = "Some banana"
    when (x) {
        is Int -> println(x + 1)
        is String -> println(x.length + 1)
        is IntArray -> println(x.sum())
    }
}