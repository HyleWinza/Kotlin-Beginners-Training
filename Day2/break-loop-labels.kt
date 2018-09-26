fun main (args : Array<String>)
{
    val list = 1..7
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    println("==========\nNo Label==========")
    for(day in days)
    {
        for(number in list)
        {
            if(number == 5)
                break

            println("Current day is $day")
        }
    } 

    println("==========\nWith Label==========")
    fistrLoop@ for(day in days)
    {
        for(number in list)
        {
            if(number == 5)
                break@fistrLoop

            println("Current day is $day")
        }
    } 

    println("... done!")
}