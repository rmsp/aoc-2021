package nl.rmspek.aoc2021.day1

import nl.rmspek.aoc2021.util.readDepthList

fun countIncreases(depthList: List<Int>): Int {
    var rises = 0
    var prev: Int? = null
    depthList.forEach {
        if (prev != null && it > prev!!) {
            rises++
        }

        prev = it
    }

    return rises
}

fun main() {
    println(countIncreases(readDepthList(1)))
}
