
fun main(args: Array<String>) {

    val lfunc = {x:Int, _:Int ->
        var sum: Int = x+2
        sum*sum
    }

    //call the lambda
    println("Calling lambda with 4 and 5 returns ${lfunc(4,5)}")

    higherOrder("Stefano Kii", {age:Int, marks: Int-> println("Passed data is Age:$age, Marks:$marks") })
}

fun higherOrder(name: String, func: (age:Int, marks: Int) -> Unit )
{
    println("Name: $name")
    func(4, 5)
}