package nl.rmspek.aoc2021.day1

import nl.rmspek.aoc2021.util.readDayInput
import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(readDayInput(1))
    var prev: Int? = null
    var rises = 0
    while(scan.hasNextLine()) {
        val curr = scan.nextLine().toInt()

        if(prev != null && curr > prev) {
            rises++
        }

        prev = curr
    }

    println(rises)
}
