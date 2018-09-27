fun main(args: Array<String>) {
    val nameList: MutableSet<String>  = mutableSetOf("Jean Pierre", "Big Name", "Cat Meow", "Jean Pierre")
    for(name in nameList)
    {
        println(name)
    }
    println("=========\nAdding some data\n=========")
    nameList.add("Mike Jordan")
    nameList.add("Mbappe")
    nameList.add("Eden Hazard")
    nameList.add("Eden Hazard")
    nameList.add("Eden Hazard")

    for(name in nameList)
    {
        println("After adding: $name")
    }

    nameList.forEach({
        println("Iterated: $it")
    })

    val filter : String = "rd"
    nameList.filter({it.contains(filter)})
        .map({it.toUpperCase()})
        .forEach({ println("After filter and map: $it")})

}