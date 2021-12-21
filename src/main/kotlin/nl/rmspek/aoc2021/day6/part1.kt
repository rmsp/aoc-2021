package nl.rmspek.aoc2021.day6

import nl.rmspek.aoc2021.util.readDayInput

fun main() {
    val fish = parseFish(readDayInput(6)).toMutableList()
    val pop = Population(fish).also { it.passDays(80) }
    println(pop.size())
}
