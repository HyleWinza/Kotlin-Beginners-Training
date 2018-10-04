open class Student(var name : String)
{
    open fun sayHi()
    {
        println("Hi! My name is ${this.name}")
    }

    companion object Factory
    {
        fun create(name: String) : Student
        {
            return Student(name)
        }
    }
}

fun main(args: Array<String>) {
    
    val mazengo = Student.create("Kiah Site")
    mazengo.sayHi()
}