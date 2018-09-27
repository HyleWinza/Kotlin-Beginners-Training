
class Student(val firstName: String, val lastName: String)
{
    var firstTime: String
    init{
        firstTime = "First Name is $firstName"
        println(firstTime)
    }

    var secondTime: String
    init{
        secondTime = "Last name is $lastName"
        println(secondTime)
    }

    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName) {
        println("Secondary Ctor with age $age")
    }
}

fun main(args: Array<String>) {
    val student = Student("Roza", "John", 28)
    println("Object is $student")
}