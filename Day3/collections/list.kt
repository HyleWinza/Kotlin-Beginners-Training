fun main(args: Array<String>) {
    val nameList: MutableList<String>  = mutableListOf("Jean Pierre", "Big Name", "Cat Meow")
    for(name in nameList)
    {
        println(name)
    }
    println("=========\nAdding some data\n=========")
    nameList.add("Mike Jordan")
    nameList.add("Mbappe")
    nameList.add("Eden Hazard")
    for(name in nameList)
    {
        println("After adding: $name")
    }

    nameList.forEach({
        println("Iterated: $it")
    })

    val filter : String = "rd"
    nameList.filter({it.contains(filter)}).forEach({ println("After filter: $it")})

}