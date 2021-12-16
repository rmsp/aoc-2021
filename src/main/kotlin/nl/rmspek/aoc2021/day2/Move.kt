package nl.rmspek.aoc2021.day2

import nl.rmspek.aoc2021.util.readStringList
import java.util.*

fun parseMoves(moves: List<String>): List<Move> =
    readStringList(2).map { instruction ->
        Scanner(instruction).use {
            Move(parseDirection(it.next()), it.nextInt())
        }
    }

data class Move(val direction: Direction, val distance: Int)
