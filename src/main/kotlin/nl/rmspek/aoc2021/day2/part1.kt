package nl.rmspek.aoc2021.day2

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    Space().also { space ->
        parseMoves(readStringList(2)).forEach { space.move(it) }
        println(space)
        println(space.hPos * space.vPos)
    }
}
