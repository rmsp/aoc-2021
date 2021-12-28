package nl.rmspek.aoc2021.day14

import nl.rmspek.aoc2021.util.bigTally
import java.math.BigInteger

class TemplateState(
    private val pairCount: Map<Pair<String, String>, BigInteger>,
    val charCount: Map<Char, BigInteger>,
    val finalChar: Char
)
    : Map<Pair<String, String>, BigInteger> by pairCount

fun fromTemplate(template: Template) = TemplateState(
    template.pairs().bigTally(),
    template.value.bigTally(),
    template.value.last()
)

fun TemplateState.iterate(rules: InsertionRules): TemplateState {
    val newPairs = mutableMapOf<Pair<String, String>, BigInteger>()
    val newCharsCount = mutableMapOf<Char, BigInteger>()
    this.forEach { pairState: Map.Entry<Pair<String, String>, BigInteger> ->
        val first: String = pairState.key.first
        val second: String = pairState.key.second
        val additional: String = rules[pairState.key]!!
        val firstPair = Pair(first, additional)
        val secondPair = Pair(additional, second)
        newPairs[firstPair] = (newPairs[firstPair] ?: BigInteger.ZERO) + pairState.value
        newPairs[secondPair] = (newPairs[secondPair] ?: BigInteger.ZERO) + pairState.value
        newCharsCount[first[0]] = (newCharsCount[first[0]] ?: BigInteger.ZERO) + pairState.value
        newCharsCount[additional[0]] = (newCharsCount[additional[0]] ?: BigInteger.ZERO) + pairState.value
    }

    newCharsCount[finalChar] = newCharsCount[finalChar]!! + BigInteger.ONE
    return TemplateState(newPairs, newCharsCount, finalChar)
}
