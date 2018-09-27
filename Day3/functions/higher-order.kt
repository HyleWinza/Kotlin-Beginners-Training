
fun main(args: Array<String>) {
    higherOrder("Stefano Kii", ::called)
}

fun higherOrder(name: String, func: (age:Int, marks: Int) -> Unit)
{
    println("Name: $name")
    func(4, 5)

    //call another HOF
    val funcAsVal = higherOrderReturn(name)
    funcAsVal(100, 200)
}

fun higherOrderReturn(name :String): (age:Int, marks: Int) -> Unit
{
    println("Higher Order returning function called with name $name")
    return ::called
}

fun called(age: Int, marks: Int)
{
    println("Passed data is Age:$age, Marks:$marks")
}