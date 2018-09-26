fun main (args : Array<String>)
{
    var x  = 10;

    println("=========\nWhile Loop\n======")
    while(x > 0)
    {
        println("Curent value of x is $x")
        x--
    }  

    x = 10
    println("=========\nDo-While Loop\n======")
    do
    {
        println("Curent value of x is $x")
        x--
    } while(x > 0)

    println("... done!")
}