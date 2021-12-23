package nl.rmspek.aoc2021.day12

class Graph {
    val nodes = mutableListOf<Node>()
    fun addEdgeInput(nodePair: Pair<String, String>) {
        val a = findOrAdd(nodePair.first)
        val b = findOrAdd(nodePair.second)
        a.neighbors.add(b)
        b.neighbors.add(a)
    }

    fun allPaths(): List<Path> {
        return start().let { toEnd(it, Path(mutableListOf(it))) }
    }

    private fun toEnd(from: Node, path: Path): MutableList<Path> {
        if (from == end()) {
            return mutableListOf(path)
        }

        val toVisit = from.neighbors - path.nodes.filter { !it.isBig() }
        return when {
            toVisit.isEmpty() -> mutableListOf() // no valid paths
            else -> toVisit.flatMap { toEnd(it, amendPath(path, it))  }.toMutableList()
        }
    }

    private fun amendPath(path: Path, it: Node): Path {
        val newNodes = mutableListOf<Node>()
        newNodes.addAll(path.nodes)
        newNodes.add(it)
        return Path(newNodes)
    }

    fun start(): Node = nodes.find { it.name == "start" }!!
    fun end(): Node = nodes.find { it.name == "end" }!!

    private fun findOrAdd(nodeName: String) =
        nodes.find { it.name == nodeName } ?: Node(nodeName).also { nodes.add(it) }
}
