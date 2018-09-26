fun main (args : Array<String>)
{
    val x : Int = 20
    val y : Int = 4

    val z : Int = if( x > y)
    {
        x+y 
    }
    else
    {
        println("Could not calculate anything!")
        x - y;
    }
    println("Returned Value is $z")
}