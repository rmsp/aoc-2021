package nl.rmspek.aoc2021.day4

import java.util.*

class Row(val boxes: List<Box>) {
    fun check(input: Int): Boolean {
        boxes.filter { it.value == input }.forEach { it.checked = true }

        return winner()
    }

    fun winner() = boxes.all { it.checked }
}

fun parseRow(string: String): Row {
    val scan = Scanner(string)
    return Row((0 until X_SZ).map { Box(scan.nextInt()) })
}
