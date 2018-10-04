
open class Student(val firstName: String, val lastName: String)
{
    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName) {
        println("Secondary Ctor with age $age")
    }

    open fun greetings() : String
    {
        return "Greetings from ${this.firstName} ${this.lastName}"
    }
}

class AnotherStudent constructor(firstName: String, lastName: String, val className: String): Student(firstName, lastName)
{
    override fun greetings() : String
    {
        return "Greetings from ${this.firstName} ${this.lastName} of ${this.className}"
    }
}

fun main(args: Array<String>) {
    val student = Student("Marcel", "Dessaily")
    val bungeStudent = AnotherStudent("Roza", "John", "Bunge Primary std 7")
    println(student.greetings())
    println(bungeStudent.greetings())
}