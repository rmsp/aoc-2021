package nl.rmspek.aoc2021.day8

inline class DisplayPattern(val value: String)

fun DisplayPattern.containsOther(displayPattern: DisplayPattern) = displayPattern.value.all { this.value.contains(it) }
