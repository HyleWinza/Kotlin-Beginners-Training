fun main (args : Array<String>)
{
    val x = 12.2

    println("First result: ${divider(x)}")
    println("Second result: ${divider(x, 4)}")
}

fun divider(x: Double, y: Int = 2) : Double
{
    return x/y
}
