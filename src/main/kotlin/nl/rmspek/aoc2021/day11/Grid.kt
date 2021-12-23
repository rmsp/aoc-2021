package nl.rmspek.aoc2021.day11

@ExperimentalStdlibApi
class Grid(val rows: List<MutableList<Octopus>>) {
    var flashCount = 0

    fun doStep(stepCount: Int) = repeat(stepCount) { step() }

    fun at(point: Point): Octopus = rows[point.y][point.x]

    fun set(point: Point, octopus: Octopus): Octopus = octopus.also { rows[point.y][point.x] = octopus }

    private fun step() {
        val hasFlashed = mutableListOf<Point>()
        val doIncrease = ArrayDeque(everyPoint())
        while (doIncrease.isNotEmpty()) {
            val point = doIncrease.removeFirst()
            val octopus = set(point, at(point).step())
            if (octopus.energyLevel > 9 && point !in hasFlashed) {
                doIncrease.addAll(point.validSurroundings(rows.first().size, rows.size))
                hasFlashed += point
            }
        }
        hasFlashed.forEach { set(it, Octopus(0)) }
        flashCount += hasFlashed.size
    }

    private fun everyPoint(): List<Point> = (rows.indices).flatMap { y ->
        (rows.first().indices).map { x -> Point(x, y) }
    }

    fun print() {
        rows.forEach { row ->
            println(row.map { it.energyLevel }.joinToString(""))
        }
    }
}

@ExperimentalStdlibApi
fun parseGrid(row: List<String>) = Grid(row.map(::parseRow))

fun parseRow(row: String): MutableList<Octopus> = row.map { Octopus("$it".toInt()) }.toMutableList()
