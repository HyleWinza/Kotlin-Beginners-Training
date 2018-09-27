
open class Student(val firstName: String, val lastName: String)
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

class AnotherStudent : Student
{
    constructor(firstName: String, lastName: String, className: String): super(firstName, lastName)
}

fun main(args: Array<String>) {
    val student = AnotherStudent("Roza", "John", "Bunge Primary std 7")
    println("Object is $student")
}