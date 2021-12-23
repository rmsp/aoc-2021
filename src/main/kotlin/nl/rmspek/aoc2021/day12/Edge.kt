package nl.rmspek.aoc2021.day12

import java.util.*

data class Edge(val a: Node, val b: Node)

fun parseEdgeInput(edge: String): Pair<String, String> = Scanner(edge)
    .useDelimiter("-")
    .let { Pair(it.next(), it.next()) }
