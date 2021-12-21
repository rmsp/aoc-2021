package nl.rmspek.aoc2021.day6

import java.math.BigInteger

class ExponentialPopulation(var map: MutableMap<Int, BigInteger>) {
    fun popSize(): BigInteger = map.values.reduce { acc, bigInteger -> acc.plus(bigInteger) }
}

fun ExponentialPopulation.passDays(days: Int) {
    (1..days).forEach { day ->
        val newMap = initializeDayMap()
        (0..8).forEach { age ->
            when(age) {
                0 -> {
                    newMap[6] = map[age]!! + newMap[6]!!
                    newMap[8] = map[age]!! + newMap[8]!!
                }
                else -> {
                    newMap[age - 1] = map[age]!! + newMap[age - 1]!!
                }

            }
        }
        map = newMap
    }
}

fun initializeDayMap(): MutableMap<Int, BigInteger> = mutableMapOf<Int, BigInteger>().also {
    (0..8).map { day -> Pair(day, BigInteger.valueOf(0)) }.toMap(it)
}
