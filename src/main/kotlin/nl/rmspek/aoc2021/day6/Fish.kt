package nl.rmspek.aoc2021.day6

import java.util.*
import java.util.regex.Pattern

inline class Fish(val days: Int)

fun parseFish(state: String): MutableList<Fish> {
    val scan = Scanner(state).useDelimiter(Pattern.compile("[,\\n]"))
    val result = mutableListOf<Fish>()
    while (scan.hasNextInt()) {
        result.add(Fish(scan.nextInt()))
    }

    return result
}
