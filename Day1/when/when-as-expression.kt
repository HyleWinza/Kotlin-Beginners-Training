fun main (args : Array<String>)
{
    val today = 4

    var theDay = when(today){
        1 -> "Today is Monday"
        2 -> "It is Tuesday"
        3,4,5 -> "Some middle days"
        else -> "Thank God it is Friday (TGIF)"
    }

    println("Today is $theDay")
}