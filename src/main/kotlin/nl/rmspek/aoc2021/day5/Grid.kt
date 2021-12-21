package nl.rmspek.aoc2021.day5

class Grid(maxX: Int, maxY: Int) {
    private val grid: List<MutableList<Int>> = (0 .. maxY).map { MutableList(maxX + 1) { 0 } }

    fun addLine(line: LineSegment) {
        when {
            line.verticalDistance() == 0 -> writeHorizontal(line.begin.y, line.begin.x, line.end.x)
            line.horizontalDistance() == 0 -> writeVertical(line.begin.x, line.begin.y, line.end.y)
            else -> writeDiagonal(line)
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

    private fun writeDiagonal(line: LineSegment) {
        val xPath = between(line.begin.x, line.end.x)
        val yPath = between(line.begin.y, line.end.y)
        (0 until xPath.count()).forEach { idx ->
            grid[yPath[idx]][xPath[idx]]++
        }
    }

    private fun between(a: Int, b: Int): List<Int> = when {
        a > b -> IntRange(b, a).reversed().toList()
        a < b -> IntRange(a, b).toList()
        else -> IntRange(a, a).toList()
    }

    fun print() {
        grid.forEach { row ->
            row.forEach { print(if (it == 0) "." else it) }
            println()
        }
    }
}
