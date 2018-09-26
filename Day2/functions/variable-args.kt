fun main (args : Array<String>)
{
    println("Sum is ${sum(1.1, 2.2, 3.3)}")
    println("Sum is ${sum(1.1, 2.2, 3.3, 4.4)}")
    println("Sum is ${sum(1.1, 2.2, 3.3, 4.4, 5.5)}")
}

fun sum(vararg numbers: Double) : Double
{
    var answer = 0.0
    
    for(number in numbers)
    {
        answer+= number
    }

    return answer
}
