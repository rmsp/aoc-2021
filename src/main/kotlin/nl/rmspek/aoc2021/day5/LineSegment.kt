package nl.rmspek.aoc2021.day5

import java.util.*
import kotlin.math.abs
import kotlin.math.max

class LineSegment (val begin: Point, val end: Point) {
    fun isDiagonal() = !(horizontalDistance() == 0 || verticalDistance() == 0)
    fun horizontalDistance(): Int = abs(begin.x - end.x)
    fun verticalDistance(): Int = abs(begin.y - end.y)

    override fun toString(): String = "$begin -> $end"
}

fun List<LineSegment>.max(): Pair<Int, Int> = Pair(
    this.map { max(it.begin.x, it.end.x) }.max()!!,
    this.map { max(it.begin.y, it.end.y) }.max()!!
)

fun parseLines(lines: List<String>): List<LineSegment> {
    return lines.map(::parseLineSegment)
}

private fun parseLineSegment(lineSegment: String): LineSegment {
    val scan = Scanner(lineSegment.replace(" -> ", ",")).useDelimiter(",")
    val begin = Point(scan.nextInt(), scan.nextInt())
    val end = Point(scan.nextInt(), scan.nextInt())
    return LineSegment(begin, end)
}
