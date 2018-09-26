fun main (args : Array<String>)
{
    var x : Int = 2
    println("Sum is ${x.sum(2)}") 
}

fun Int.sum(another : Int) : Int
{
    return this + another
}
