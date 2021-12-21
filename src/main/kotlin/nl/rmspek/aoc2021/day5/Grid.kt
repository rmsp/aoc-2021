package nl.rmspek.aoc2021.day5

class Grid(maxX: Int, maxY: Int) {
    private val grid: List<MutableList<Int>> = (0 .. maxY).map { MutableList(maxX + 1) { 0 } }

    fun addLine(line: LineSegment) {
        when {
            line.verticalDistance() == 0 -> writeHorizontal(line.begin.y, line.begin.x, line.end.x)
            line.horizontalDistance() == 0 -> writeVertical(line.begin.x, line.begin.y, line.end.y)
            else -> throw Error("Line is diagonal")
        }
    }

    fun countDangerZone(inclusiveCutoff: Int): Int = grid.flatten().count { it >= inclusiveCutoff }

    // exclusive endX
    private fun writeHorizontal(y: Int, startX: Int, endX: Int) {
        between(startX, endX).forEach { grid[y][it]++ }
    }

    private fun writeVertical(x: Int, startY: Int, endY: Int) {
        between(startY, endY).forEach { grid[it][x]++ }
    }

    private fun between(a: Int, b: Int): IntRange = when {
        a > b -> IntRange(b, a)
        a < b -> IntRange(a, b)
        else -> IntRange(a, a)
    }

    fun print() {
        grid.forEach { row ->
            row.forEach { print(if (it == 0) "." else it) }
            println()
        }
    }
}
