
fun main(args: Array<String>) {

    val lfunc = fun (x:Int, y:Int) : Int
    {
        var sum: Int = x+y
        return sum*sum
    }

    //call the Anonymous
    println("Calling Anonymous with 4 and 5 returns ${lfunc(4,5)}")

    higherOrder("Stefano Kii", fun (age:Int, marks: Int) = println("Passed data is Age:$age, Marks:$marks"))
}

fun higherOrder(name: String, func: (age:Int, marks: Int) -> Unit )
{
    println("Name: $name")
    func(4, 5)
}