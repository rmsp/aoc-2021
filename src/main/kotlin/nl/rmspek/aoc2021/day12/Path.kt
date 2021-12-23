package nl.rmspek.aoc2021.day12

class Path(val nodes: MutableList<Node> = mutableListOf()) {
    override fun toString() = nodes.joinToString { it.name }
}
