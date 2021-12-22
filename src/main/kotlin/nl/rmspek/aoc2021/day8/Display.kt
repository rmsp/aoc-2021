package nl.rmspek.aoc2021.day8

import java.util.*

class Display(val allPatterns: List<DisplayPattern>, val outputPatterns: List<DisplayPattern>)

fun parseDisplays(displays: List<String>): List<Display> = displays.map(::parseDisplay)

fun parseDisplay(line: String): Display {
    val scan = Scanner(line)
    val allPatterns = (0 until 10).map { DisplayPattern(scan.next()) }
    scan.next()
    return Display(
        allPatterns,
        (0 until 4).map { DisplayPattern(scan.next()) }
    )
}
