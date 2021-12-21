package nl.rmspek.aoc2021.day6

import kotlin.time.days

const val OLD_FISH_RESET_DAYS = 6
const val NEW_FISH_DAYS = 8

class Population(private val fish: MutableList<Fish>) {
    fun passDays(days: Int) {
        //println("initial state: $this")
        (1..days).forEach { day ->
            var newFish = 0
            fish.forEachIndexed { idx, it ->
                when(it.days) {
                    0 -> {
                        fish[idx] = Fish(OLD_FISH_RESET_DAYS)
                        newFish++
                    }
                    else -> fish[idx] = Fish(it.days - 1)
                }
            }

            (0 until newFish).forEach { fish.add(Fish(NEW_FISH_DAYS)) }
            //println("After $day days: $this")
        }
    }

    fun size(): Int = fish.size

    override fun toString(): String = fish.joinToString { it.days.toString() }
}
