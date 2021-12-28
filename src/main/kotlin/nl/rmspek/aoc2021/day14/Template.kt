package nl.rmspek.aoc2021.day14

import java.util.*

inline class Template(val value: String)

fun Template.pairs(): Sequence<Pair<String, String>> = sequence {
    value.indices.take(value.length - 1).forEach { startIdx ->
        yield(Pair(value[startIdx].toString(), value[startIdx+1].toString()))
    }
}

fun parseTemplate(scan: Scanner): Template = Template(scan.nextLine()).also { scan.nextLine() }
