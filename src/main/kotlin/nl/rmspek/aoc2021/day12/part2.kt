package nl.rmspek.aoc2021.day12

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    runInput("test1")
    runInput("test2")
    runInput("test3")
    runInput("input")
}

private fun runInput(input: String) {
    val graph = Graph()
    val edgeInputs = readStringList(12, input).map(::parseEdgeInput)
    edgeInputs.forEach { graph.addEdgeInput(it) }
    val allPaths = graph.allPathsVisitTwice()
//    allPaths.forEach { println(it) }
    println(allPaths.size)
}
