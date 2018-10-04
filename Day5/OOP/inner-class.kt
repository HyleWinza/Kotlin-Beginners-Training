
open class Student(val firstName: String, val lastName: String)
{
    open val age = 12;

    open fun greetings() : String
    {
        return "Greetings from ${this.firstName} ${this.lastName} aged ${this.age}"
    }
}

class AnotherStudent constructor(firstName: String, lastName: String, override val age: Int): Student(firstName, lastName)
{
    override fun greetings() : String
    {
        return "${super.greetings()} with ${this.age}"
    }
}

fun main(args: Array<String>) {
    val student = Student("Marcel", "Dessaily")
    val bungeStudent = AnotherStudent("Roza", "John", 20)
    println(student.greetings())
    println(bungeStudent.greetings())
}