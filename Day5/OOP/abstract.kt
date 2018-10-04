abstract class BaseKids
{
    abstract fun getName(): String

    fun cry()
    {
        println("Baby ${this.getName()} is crying..!")
    }
}

class BabyKii : BaseKids()
{
    override fun getName() : String
    {
        return "Kiah!"
    }
}

fun main(args: Array<String>)
{
    val b = BabyKii()
    b.cry()
}