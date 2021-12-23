package nl.rmspek.aoc2021.day11

import nl.rmspek.aoc2021.util.readStringList

@ExperimentalStdlibApi
fun main() {
    val grid = parseGrid(readStringList(11))
    val max = grid.octopusCount()
    var step = 1
    while (max != grid.step().size) {
        step++
    }
    println(step)
}
