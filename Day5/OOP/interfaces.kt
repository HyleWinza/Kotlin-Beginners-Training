interface IStudent
{
    var name: String

    fun sayHi(): Unit
}


 class Student(var n : String) : IStudent
{
    override var name: String = "";

    init{
        this.name = n
    }

    override fun sayHi()
    {
        println("Hi! My name is ${this.name}")
    }
}

fun main(args: Array<String>) {

    val msalato = Student("Wendo Kasa")
    msalato.sayHi()
}