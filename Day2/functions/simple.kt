fun main (args : Array<String>)
{
    val x = 12.2
    val y = 14.52

    println("Square of $x is ${square(x)}")
    println("Sum of $x and $y is ${add(x, y)}")
}

fun square(x: Double) : Double
{
    return x*x
}

fun add(a: Double, b: Double) = a+b //single line function