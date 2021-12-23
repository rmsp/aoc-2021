package nl.rmspek.aoc2021.day12

import nl.rmspek.aoc2021.day8.tally

class Path(val nodes: MutableList<Node> = mutableListOf()) {
    override fun toString() = nodes.joinToString { it.name }
}

fun Path.smallCaves() = nodes.filter { !it.isBig() }

fun Path.hasVisitedSmallCaveTwice() = this.smallCaves().tally().values.any { it > 1 }

fun Path.amend(node: Node): Path = Path(
    mutableListOf<Node>().also {
        it.addAll(nodes)
        it.add(node)
    }
)
