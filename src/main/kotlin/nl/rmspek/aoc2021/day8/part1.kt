package nl.rmspek.aoc2021.day8

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    val displays = parseDisplays(readStringList(8))
    println(displays.flatMap { it.outputPatterns }.count(::is1478))
}

fun is1478(pattern: DisplayPattern) = when(pattern.value.length) {
    2, 4, 3, 7 -> true
    else -> false
}
