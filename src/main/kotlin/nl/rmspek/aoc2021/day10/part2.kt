package nl.rmspek.aoc2021.day10

import nl.rmspek.aoc2021.util.readStringList
import java.math.BigInteger
import java.util.*

fun main() {
    val lines = readStringList(10)
    val finishedSequences = finishIncompleteSequences(lines)
    finishedSequences.forEach { println(it) }
    println(finishedSequences.map { score(it) }.median())
}

fun List<BigInteger>.median(): BigInteger {
    val count = count()
    val middle = count / 2
    val sorted = this.sorted()
    return if (count() % 2 == 0) {
        (sorted[middle] + sorted[middle - 1]).div(BigInteger.valueOf(2))
    } else {
        sorted[middle]
    }
}

private fun finishIncompleteSequences(lines: List<String>): List<String> = lines.mapNotNull(::finishSequence)

private fun finishSequence(line: String): String? {
    val stack = Stack<Char>()
    line.forEach {
        when {
            openingChar.contains(it) -> stack.push(it)
            stack.peek() != reverse(it) -> return null
            else ->  stack.pop()
        }
    }

    return stack.reversed().map(::reverse).joinToString("")
}

private fun score(line: String): BigInteger {
    var score = BigInteger.valueOf(0)
    line.forEach { char ->
        score *= BigInteger.valueOf(5)
        score += charPoints(char)
    }
    return score
}

private fun charPoints(char: Char) = when(char) {
    ')' -> BigInteger.valueOf(1)
    ']' -> BigInteger.valueOf(2)
    '}' -> BigInteger.valueOf(3)
    '>' -> BigInteger.valueOf(4)
    else -> throw Error("Bad char $char")
}
