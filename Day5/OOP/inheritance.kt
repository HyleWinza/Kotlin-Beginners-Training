
open class Student(val firstName: String, val lastName: String)
{
    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName) {
        println("Secondary Ctor with age $age")
    }
}

class AnotherStudent constructor(firstName: String, lastName: String, val className: String): Student(firstName, lastName)
{
    
}

fun main(args: Array<String>) {
    val student = AnotherStudent("Roza", "John", "Bunge Primary std 7")
    println("Property ${student.className}")
}