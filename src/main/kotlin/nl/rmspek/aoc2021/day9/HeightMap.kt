package nl.rmspek.aoc2021.day9

class HeightMap(val rows: List<List<Int>>) {
    private val colCount = rows.first().size

    fun at(x: Int, y: Int): Int = rows[y][x]
    fun surroundings(x: Int, y: Int): Surroundings {
        return Surroundings(
            if (y - 1 < 0) -1 else rows[y - 1][x],
            if (x + 1 >= colCount) -1 else rows[y][x + 1],
            if (y + 1 >= rows.size) -1 else rows[y + 1][x],
            if (x - 1 < 0) -1 else rows[y][x - 1]
        )
    }
}

fun parseHeightmap(rows: List<String>): List<List<Int>> = rows.map { row -> row.map { pos -> "$pos".toInt() } }
