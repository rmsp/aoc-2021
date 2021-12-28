package nl.rmspek.aoc2021.day13

import nl.rmspek.aoc2021.util.readDayInput
import java.util.*

fun main() {
    val scanner = Scanner(readDayInput(13))
    var points = parsePoints(scanner)
    val folds = parseFolds(scanner)

    print(doFold(points, folds, null))
}

fun print(points: Set<Pair<Int, Int>>) {
    val maxX = points.maxBy { it.first }?.first!!
    val maxY = points.maxBy { it.second }?.second!!
    (0 .. maxY).forEach { y ->
        (0 .. maxX).forEach { x ->
            when {
                points.contains(Pair(x, y)) -> print("#")
                else -> print(" ")
            }
        }
        println()
    }
}
