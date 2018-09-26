package app.main
import app.lib.* //avoid unresolved reference: addy

fun main(args: Array<String>) {
    var y = 4.0 //infer data type from value
    var answer : Double

    answer = addy(y) // imported above from another package
    println("Value of function is "+answer)
}

//compile with: kotlinc lib/libx.kt lib/liby.kt app/app.kt  -include-runtime -d app.jar && java -jar app.jar