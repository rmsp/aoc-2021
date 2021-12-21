package nl.rmspek.aoc2021.day5

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    val lines = parseLines(readStringList(5))
    val max = lines.max()
    val grid = Grid(max.first, max.second)
    lines.filter { !it.isDiagonal() || it.is45Diagonal() }.forEach { grid.addLine(it) }
    grid.print()
    println(grid.countDangerZone(2))
}
