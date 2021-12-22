package nl.rmspek.aoc2021.day8

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    val displays = parseDisplays(readStringList(8))
    val findOutput = displays.map(::deduceDisplayOutputs)
    println(findOutput.joinToString())
    println(findOutput.sum())
}

fun <T> Iterable<T>.tally(): Map<T, Int> {
    val result = mutableMapOf<T, Int>()
    this.forEach { result.compute(it) { k,v -> if (v == null || k == null) 1 else v + 1 } }
    return result
}

private fun deduceDisplayOutputs(display: Display): Int {
    val bval = findOccurrence(display.allPatterns, 6)
    val eval = findOccurrence(display.allPatterns, 4)
    val val1 = display.allPatterns.find { it.value.length == 2 }!!

    return display.outputPatterns.map { deduceOutput(it, bval, eval, val1) }.joinToString("").toInt(10)
}

private fun deduceOutput(outputVal: DisplayPattern, bval: Char, eval: Char, val1: DisplayPattern): Int {
    return when (outputVal.value.length) {
        2 -> 1
        3 -> 7
        4 -> 4
        5 -> deduce5(outputVal, bval, eval)
        6 -> deduce6(outputVal, eval, val1)
        7 -> 8
        else -> throw Error("HOW?")
    }
}

private fun deduce5(outputVal: DisplayPattern, bval: Char, eval: Char): Int {
    return when {
        outputVal.value.contains(eval) -> 2
        outputVal.value.contains(bval) -> 5
        else -> 3
    }
}

private fun deduce6(outputVal: DisplayPattern, eval: Char, val1: DisplayPattern): Int {
    return when {
        !outputVal.value.contains(eval) -> 9
        outputVal.containsOther(val1) -> 0
        else -> 6
    }
}

private fun findOccurrence(list: List<DisplayPattern>, occurrenceCount: Int): Char {
    val tally = list.flatMap { it.value.asIterable() }.tally()
    return tally.filter { it.value == occurrenceCount }.let { when {
        it.size > 1 -> throw Error("Can only deduce unique ocurrences")
        else -> it.entries.first().key
    } }
}
