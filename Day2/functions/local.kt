fun main (args : Array<String>)
{
    println("Average is ${average(1.1, 2.2, 3.3)}") 
}

fun average(vararg numbers: Double) : Double
{
    fun sum(nlist: DoubleArray): Double
    {
        var answer = 0.0
        for(number in nlist)
        {
            answer+= number
        }
        return answer
    }

    return sum(numbers)/numbers.size.toDouble()
}
