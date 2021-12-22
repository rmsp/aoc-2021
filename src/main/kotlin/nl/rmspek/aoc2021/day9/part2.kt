package nl.rmspek.aoc2021.day9

import nl.rmspek.aoc2021.util.readStringList

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val map = HeightMap(parseHeightmap(readStringList(9)))
    val lowPoints = findLowPoints(map).toMutableList()
    val basins = mutableListOf<Set<Pair<Int, Int>>>()

    lowPoints.forEach { lowPoint ->
        val visited: MutableSet<Pair<Int, Int>> = mutableSetOf()
        val toVisit: ArrayDeque<Pair<Int, Int>> = ArrayDeque(listOf(lowPoint))
        do {
            val point = toVisit.removeFirst()
            val validNeighbours = map.surroundings(point)
                .filterNotNull()
                .filter { map.at(it) != 9 }
                .filter { !visited.contains(it) }

            validNeighbours
                .filter { lowPoints.contains(it) }
                .forEach { lowPoints.remove(it) }

            toVisit.addAll(validNeighbours)
            visited.add(point)
        } while(toVisit.isNotEmpty())

        basins.add(visited)
    }

    basins.sortByDescending { it.size }
    basins.take(3).forEach(::println)
    println(basins[0].size * basins[1].size * basins[2].size)
}

fun findLowPoints(map: HeightMap): Sequence<Pair<Int, Int>> = sequence {
    (map.rows.indices).forEach { y ->
        (map.rows[y].indices).forEach { x ->
            val value = map.at(x, y)
            if (map.surroundings(x, y).filterNotNull().none { map.at(it.first, it.second) <= value }) {
                yield(Pair(x, y))
            }
        }
    }
}
