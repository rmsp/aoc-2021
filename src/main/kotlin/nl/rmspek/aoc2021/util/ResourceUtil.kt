package nl.rmspek.aoc2021.util

import java.nio.charset.Charset

fun readDayInput(day: Int)  = object{}.javaClass.getResource("/day${day}/input").readText(Charset.forName("UTF-8"))
