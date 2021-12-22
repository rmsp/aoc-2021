package nl.rmspek.aoc2021.day7

import nl.rmspek.aoc2021.util.readIntLineList
import kotlin.math.abs
import kotlin.math.roundToInt

fun main() {
    val positions = readIntLineList(7)
    val fuel = calculateLinearMoveTo(positions)
    println(fuel)
}

fun calculateLinearMoveTo(positions: Sequence<Int>): Int {
    val median = positions.toList().median()
    return positions.sumBy { abs(median - it) }
}

fun List<Int>.median(): Int {
    val count = count()
    val middle = count / 2
    val sorted = this.sorted()
    return if (count() % 2 == 0) {
        listOf(sorted[middle], sorted[middle - 1]).average().roundToInt()
    } else {
        sorted[middle]
    }
}
