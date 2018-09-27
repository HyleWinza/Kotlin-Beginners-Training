class Student constructor(val name: String, val age: Int)
{

}

fun main(args: Array<String>) {
    val student = Student("Juma Mashaka", 28)

    println("Name is ${student.name} of age ${student.age}")
}