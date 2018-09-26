fun main (args : Array<String>)
{
    //call the function
    val name = askName()
    printName(name)
}

fun printName(name : String?) : Unit
{
    println("The provided name is: "+name)
}

fun askName() : String?
{
    println("Please enter your name:")
    return readLine()
}