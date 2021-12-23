package nl.rmspek.aoc2021.day12

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    val graph = Graph()
    val edgeInputs = readStringList(12).map(::parseEdgeInput)
    edgeInputs.forEach { graph.addEdgeInput(it) }
    val allPaths = graph.allPaths()
    allPaths.forEach { println(it) }
    println(allPaths.size)
}
