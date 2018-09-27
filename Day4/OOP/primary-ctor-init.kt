
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
}

fun main(args: Array<String>) {
    val student = Student("Roza", "John")
    println("Object is $student")
}