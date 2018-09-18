fun main(args: Array<String>) {

    println("-------------Lambdas-------------")
    // higher order functions
    // filter
    val ints = listOf(2, 3, 20, 50)
    println(ints.filter { it > 10 })

    // filter & sum
    println(ints.filter { it > 1 }.sum())                                           // 75

    // chaining higher order functions
    val myStringList = listOf("Sam", "Suzzy", "Jesse", "Ray", "Kevin")
    val updatedList = myStringList.filter { it.length > 3 }.sortedBy { it }
    println(updatedList)                                                            // [Jesse, Kevin, Suzzy]

    // passing lambdas into functions
    fun handleInteger(myInt: Int, operation: (Int) -> Unit) {
        operation(myInt)
    }

    handleInteger(5, { println("My Result is ${it*10}")})                    // My Result is 50
    handleInteger(5, { myType -> println("My Result is ${myType*10}")})      // My Result is 50

    // function reference
    fun printResult(myInt: Int) {
        println("My Int is $myInt")
    }

    handleInteger(4, ::printResult)                                         // My Int is 4


    // Challenges

    // -----------Print out the index and value of the map below------------
    val names = mapOf<String, Int>("John" to 32, "Fred" to 24, "Tanin" to 24)
    for ((index, value) in names) {
        println("index = $index value = $value")
    }

    // -----------Destructuring Data class-----------------
    data class Person(val name: String, val age: Int)
    val sam = Person("Sam", 30)

    val (name, age) = sam
    println("$name is $age years old")                                             // Same is 30 years old

    println("-----------------Generics--------------------")
    printItem("something to print")
    printItem(1)

    fun <T> printList(list: List<T>) {
        for (item in list) {
            println("List item : $item")
        }
    }
    printList(listOf(1,2,3,4))

    // Collection Method: any method - check if any elements match the condition
    val cities = listOf("London", "Liverpool", "Manchester", "Leicester")
    println(cities.any { it == "London" })                                         // true

    // Collection Method: all - check all elements in the collection
    println(cities.all { it.length > 7 })                                          // false


}

// Generics
interface Repository<T>{
    fun addItem(item: T)
    fun deleteItem(item: T)
}

class Person(val name: String) {}

class PersonRepository : Repository<Person> {
    override fun deleteItem(item: Person) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addItem(item: Person) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

// generic functions
fun <T> printItem(item: T) {
    println(item)
}