package nl.rmspek.aoc2021.day11

import nl.rmspek.aoc2021.util.readStringList

@ExperimentalStdlibApi
fun main() {
    val grid = parseGrid(readStringList(11))
    grid.doStep(100)
    println(grid.flashCount)
}
