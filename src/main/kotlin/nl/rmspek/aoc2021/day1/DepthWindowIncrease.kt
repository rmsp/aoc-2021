package nl.rmspek.aoc2021.day1

import nl.rmspek.aoc2021.util.readDepthList

fun main() {
    val windows = depthWindowsFromList(readDepthList(1), 3)
    println(countIncreases(windows.map { it.sum() }))
}
