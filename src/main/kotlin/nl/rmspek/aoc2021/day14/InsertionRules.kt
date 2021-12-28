package nl.rmspek.aoc2021.day14

import java.util.*

class InsertionRules(private val rules: Map<Pair<String, String>, String>): Map<Pair<String, String>, String> by rules

fun InsertionRules.sub(template: Template): Template = Template(
    template
        .pairs()
        .map { "${it.first}${this[it]}" }
        .joinToString("") + template.value.last().toString()
)

fun parseInsertionRules(scan: Scanner): InsertionRules {
    val result = mutableMapOf<Pair<String, String>, String>()
    while (scan.hasNextLine()) {
        val split = scan.nextLine().split(" -> ")
        result[Pair(split[0][0].toString(), split[0][1].toString())] = split[1]
    }

    return InsertionRules(result)
}
