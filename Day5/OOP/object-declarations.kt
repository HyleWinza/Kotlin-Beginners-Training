object SingletonObject
{
    var property : Int = 1;

    fun increment()
    {
        property += 2
    }

    fun print()
    {
        println("Value is $property")
    }
}


fun main(args: Array<String>) {
    SingletonObject.increment()
    SingletonObject.print()
    SingletonObject.increment()
    SingletonObject.print()
}