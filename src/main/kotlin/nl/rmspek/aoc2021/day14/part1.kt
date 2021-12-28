package nl.rmspek.aoc2021.day14

import nl.rmspek.aoc2021.util.readDayInput
import nl.rmspek.aoc2021.util.tally
import java.util.*

fun main() {
    val scan = Scanner(readDayInput(14))
    var template = parseTemplate(scan)
    val rules = parseInsertionRules(scan)

    repeat(10) {
        template = rules.sub(template)
        println("after step ${it + 1}: $template")
    }
    val tally = template.value.tally()
    val max = tally.maxBy { it.value }!!
    val min = tally.minBy { it.value }!!
    println(tally)
    println(max.value - min.value)
}

//{O=1579, V=1984, F=2485, N=2197, K=1122, B=3523, H=2426, S=1006, C=755, P=2380}
//2768
