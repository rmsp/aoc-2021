package nl.rmspek.aoc2021.day6

import nl.rmspek.aoc2021.util.readDayInput
import java.math.BigInteger

fun main() {
    val dayMap = initializeDayMap()
    parseFish(readDayInput(6)).forEach {
        dayMap[it.days] = dayMap[it.days]!! + BigInteger.valueOf(1)
    }
    val pop = ExponentialPopulation(dayMap)
    pop.passDays(256)
    println(pop.popSize())
}
