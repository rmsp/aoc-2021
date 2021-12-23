package nl.rmspek.aoc2021.day11

data class Point(val x: Int, val y: Int)

fun Point.validSurroundings(xLimit: Int, yLimit: Int): List<Point> {
    return (-1 .. 1).flatMap { y ->
        listOf(-1, 0, 1).map { x ->
            Point(this.x + x, this.y + y)
        }
    }.filter { this != it }.filter { validSurroundingPoint(it, xLimit, yLimit) }
}

private fun validSurroundingPoint(point: Point, xLimit: Int, yLimit: Int): Boolean {
    return point.x in 0 until xLimit && point.y in 0 until yLimit
}

