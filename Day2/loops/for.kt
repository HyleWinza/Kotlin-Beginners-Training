fun main (args : Array<String>)
{
    var list = 7..100

    for(number in list)
    {
        println("Current number is $number")
    } 

    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    for((idx, day) in days.withIndex())
    {
        println("Current Index:$idx day is $day")
    } 

    println("... done!")
}