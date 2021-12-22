package nl.rmspek.aoc2021.day7

import nl.rmspek.aoc2021.util.readIntLineList
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor

fun main() {
    val positions = readIntLineList(7)
    val fuel = calculateRisingMoveTo(positions)
    println(fuel)
}

fun calculateRisingMoveTo(positions: Sequence<Int>): Int {
    val average: Double = positions.average()
    val lowAvg = floor(average).toInt()
    val highAvg = ceil(average).toInt()
    val lowFuel = positions.sumBy { fuel(abs(lowAvg - it)) }
    val highFuel = positions.sumBy { fuel(abs(highAvg - it)) }
    return listOf(lowFuel, highFuel).min()!!
}

fun fuel(step: Int): Int = (step * (step + 1)) / 2
