package com.tekadept.demo

// Add your solution here

fun main(args: Array<String>) {
    println("getSmaller")

    // Please add the getSmaller function above the main function
    val minInt: Int = getSmaller(42, 99)
    val minDouble: Double = getSmaller(9.807, 3.14159)
    val minString: String = getSmaller("kitten", "kittens")

    println("The min Int = $minInt")
    println("The min Double = $minDouble")
    println("The min String = $minString")
}
