package nl.rmspek.aoc2021.day4

import nl.rmspek.aoc2021.util.readDayInput
import java.util.*

fun main() {
    val scan = Scanner(readDayInput(4))
    val input = parseInput(scan)
    val game = Game(parseBoards(scan))

    val result = game.resolveLoser(input)
    println(result)
    println(result.input * result.sumEmpty)
}
