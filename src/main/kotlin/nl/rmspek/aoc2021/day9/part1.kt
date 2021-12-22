package nl.rmspek.aoc2021.day9

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    val map = HeightMap(parseHeightmap(readStringList(9)))
    val riskLevels = findRiskLevels(map).toList()
    println(riskLevels.sum())
}

fun findRiskLevels(map: HeightMap): Sequence<Int> = sequence {
    (map.rows.indices).forEach { y ->
        (map.rows[y].indices).forEach { x ->
            val value = map.at(x, y)
            if (map.surroundings(x, y).filter { it != -1 }.none { it <= value }) {
                yield(value + 1)
            }
        }
    }
}

