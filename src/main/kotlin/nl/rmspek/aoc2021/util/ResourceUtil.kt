package nl.rmspek.aoc2021.util

import java.nio.charset.Charset
import java.util.*
import java.util.regex.Pattern

fun readDayInput(day: Int, file: String = "input") = object{}.javaClass.getResource("/day${day}/$file").readText(Charset.forName("UTF-8"))

fun readStringList(day: Int, file: String = "input"): List<String> {
    val scan = Scanner(readDayInput(day, file))
    val result = mutableListOf<String>()
    while(scan.hasNextLine()) {
        result.add(scan.nextLine())
    }

    return result
}

fun readIntList(day: Int, file: String = "input"): List<Int> {
    val scan = Scanner(readDayInput(day, file))
    val result = mutableListOf<Int>()
    while(scan.hasNextInt()) {
       result.add(scan.nextInt())
    }

    return result
}

fun readIntLineList(day: Int, file: String = "input") = sequence {
    val scan = Scanner(readDayInput(day, file)).useDelimiter(Pattern.compile("[,\\n]"))
    while (scan.hasNextInt()) {
        yield(scan.nextInt())
    }
}
