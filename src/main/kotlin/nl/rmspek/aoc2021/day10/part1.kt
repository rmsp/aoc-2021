package nl.rmspek.aoc2021.day10

import nl.rmspek.aoc2021.util.readStringList
import java.util.*

val openingChar = listOf('(', '[', '{', '<')

fun main() {
    val lines = readStringList(10)
    val corruptChars = corruptChars(lines)
    val score = corruptChars.sumBy { score(it) }
    println(score)
}

private fun corruptChars(lines: List<String>) = lines.mapNotNull(::processLine)

private fun processLine(line: String): Char? {
    val stack = Stack<Char>()
    line.forEach {
        when {
            openingChar.contains(it) -> stack.push(it)
            stack.peek() != reverse(it) -> return it
            else ->  stack.pop()
        }
    }

    return null
}

fun reverse(char: Char) = when(char) {
    ')' -> '('
    ']' -> '['
    '}' -> '{'
    '>' -> '<'
    else -> throw Error("bad char $char")
}

private fun score (char: Char): Int = when(char) {
    ')' -> 3
    ']' -> 57
    '}' -> 1197
    '>' -> 25137
    else -> throw Error("bad char $char")
}
