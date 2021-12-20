package nl.rmspek.aoc2021.day3

data class PositionEntry(val index: Int, val positionCodes: MutableMap<Char, MutableList<Code>> = mutableMapOf())

fun PositionEntry.position() = index + 1
fun PositionEntry.exponent(codeLength: Int) = codeLength - index - 1

fun PositionEntry.tally(char: Char) = this.positionCodes[char]!!.size
fun PositionEntry.codeCount() = positionCodes.entries.sumBy { it.value.size }
fun PositionEntry.mostCommonValue(): Pair<Char, MutableList<Code>> = positionCodes.entries.maxBy { tally(it.key) }!!.toPair()
fun PositionEntry.leastCommonValue(): Pair<Char, MutableList<Code>> = positionCodes.entries.minBy { tally(it.key) }!!.toPair()
fun PositionEntry.commonalityClashes() = tally('1') == tally('0')
