open class Student(var name : String)
{
    open fun sayHi()
    {
        println("Hi! My name is ${this.name}")
    }
}

fun main(args: Array<String>) {
    
    val mazengo = object: Student("Stef D."){
        override fun sayHi()
        {
            println("Mazengo boy ${this.name} says Hi!")
        }

        fun cry()
        {
            println("Men cries from the inside..!")
        }
    }

    val msalato = Student("Wendo Kasa")

    mazengo.sayHi()
    mazengo.cry()
    
    msalato.sayHi()
}