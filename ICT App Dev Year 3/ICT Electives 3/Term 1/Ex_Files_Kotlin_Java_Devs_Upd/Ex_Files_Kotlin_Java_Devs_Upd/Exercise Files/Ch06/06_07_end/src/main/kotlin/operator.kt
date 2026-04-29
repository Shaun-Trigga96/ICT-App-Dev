// 06_07_end solution
package com.tekadept.demo

// Add your solution here

data class Cubic(var x: Int, var y: Int, var z: Int) {
    operator fun plus(other: Cubic): Cubic {
        return Cubic(x + other.x, y + other.y, z + other.z)
    }

    operator fun minus(other: Cubic): Cubic {
        return Cubic(x - other.x, y - other.y, z - other.z)
    }
}

fun main(args: Array<String>) {
    println("operator")

    val pt1 = Cubic(100, 200, 300)
    val pt2 = Cubic(10, 20, 30)

    println("pt1 = $pt1")
    println("pt2 = $pt2")
    println("pt1 + pt2 = ${pt1 + pt2}")
    println("pt1 - pt2 = ${pt1 - pt2}")
}
