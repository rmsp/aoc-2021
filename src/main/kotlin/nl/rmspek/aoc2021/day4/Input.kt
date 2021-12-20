package nl.rmspek.aoc2021.day4

import java.util.*

data class Input(val input: List<Int>)

fun parseInput(scan: Scanner): Input {
    val inputScan = Scanner(scan.nextLine()).useDelimiter(",")
    scan.nextLine()

    val result = mutableListOf<Int>()
    while(inputScan.hasNextInt()) {
        result.add(inputScan.nextInt())
    }

    return Input(result)
}
