package nl.rmspek.aoc2021.util

fun CharSequence.tally(): Map<Char, Int> {
    val result = mutableMapOf<Char, Int>()
    this.forEach {
        result.compute(it) { k, v -> if (v == null || k == null) 1 else v + 1}
    }
    return result
}
