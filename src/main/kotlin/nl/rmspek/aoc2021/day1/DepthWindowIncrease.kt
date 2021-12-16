package nl.rmspek.aoc2021.day1

import nl.rmspek.aoc2021.util.readIntList

fun main() {
    val windows = depthWindowsFromList(readIntList(1), 3)
    println(countIncreases(windows.map { it.sum() }))
}
