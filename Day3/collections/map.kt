fun main(args: Array<String>) {
    val mathMarks = mutableMapOf("Ronaldo" to 99, "Messi" to 98, "Ibrahimovic" to 75, "Khedira" to 90)

    println("Khedira = ${mathMarks["Khedira"]}")

    for((name, mark) in mathMarks)
    {
        println("$name got total of $mark%")
    }
    println("=========\nAdding some data\n=========")
    mathMarks["Hazard"] = 100
    mathMarks["Messi"] = 99

    for((name, mark) in mathMarks)
    {
        println("$name After more exercises got $mark%")
    }


    mathMarks.filter({it -> it.value < 90})  
            .mapKeys({it -> it.key.toUpperCase() })
            .mapValues({it -> it.value +5 })
            .forEach({it -> println("OOps! ${it.key} boosted to ${it.value}")})
}