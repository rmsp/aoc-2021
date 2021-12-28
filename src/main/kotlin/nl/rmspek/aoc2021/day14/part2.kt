package nl.rmspek.aoc2021.day14

import nl.rmspek.aoc2021.util.readDayInput
import java.util.*

fun main() {
    val scan = Scanner(readDayInput(14))
    var state = fromTemplate(parseTemplate(scan))
    val rules = parseInsertionRules(scan)

    repeat(40) {
        state = state.iterate(rules)
    }

    val max = state.charCount.maxBy { it.value }!!
    val min = state.charCount.minBy { it.value }!!
    println(state.charCount)
    println(max.value - min.value)
}
