package nl.rmspek.aoc2021.util

import java.nio.charset.Charset
import java.util.*

fun readDayInput(day: Int) = object{}.javaClass.getResource("/day${day}/input").readText(Charset.forName("UTF-8"))

fun readDepthList(day: Int): List<Int> {
    val scan = Scanner(readDayInput(day))
    val result = mutableListOf<Int>()
    while(scan.hasNextInt()) {
       result.add(scan.nextInt())
    }

    return result
}
