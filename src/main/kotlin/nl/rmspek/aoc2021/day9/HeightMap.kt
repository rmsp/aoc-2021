package nl.rmspek.aoc2021.day9

class HeightMap(val rows: List<List<Int>>) {
    private val colCount = rows.first().size

    fun at(point: Pair<Int, Int>) = at(point.first, point.second)
    fun surroundings(point: Pair<Int, Int>) = surroundings(point.first, point.second)

    fun at(x: Int, y: Int): Int = rows[y][x]
    fun surroundings(x: Int, y: Int): Surroundings {
        return Surroundings(
            if (y - 1 < 0) null else Pair(x, y-1),
            if (x + 1 >= colCount) null else Pair(x+1, y),
            if (y + 1 >= rows.size) null else Pair(x, y+1),
            if (x - 1 < 0) null else Pair(x-1, y)
        )
    }
}

fun parseHeightmap(rows: List<String>): List<List<Int>> = rows.map { row -> row.map { pos -> "$pos".toInt() } }
