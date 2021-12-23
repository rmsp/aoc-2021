package nl.rmspek.aoc2021.day12

class Graph {
    private val nodes = mutableListOf<Node>()

    fun addEdgeInput(nodePair: Pair<String, String>) {
        val a = findOrAdd(nodePair.first)
        val b = findOrAdd(nodePair.second)
        a.neighbors.add(b)
        b.neighbors.add(a)
    }

    fun allPaths(): List<Path> {
        return start().let { toEnd(it, Path(mutableListOf(it))) }
    }

    private fun toEnd(from: Node, path: Path): List<Path> {
        if (from == end()) {
            return listOf(path)
        }

        val toVisit = from.neighbors - path.nodes.filter { !it.isBig() }
        return when {
            toVisit.isEmpty() -> listOf() // no valid paths
            else -> toVisit.flatMap { toEnd(it, path.amend(it))  }
        }
    }

    fun allPathsVisitTwice(): List<Path> {
        return start().let { toEndVisitTwice(it, Path(mutableListOf(it))) }
    }

    private fun toEndVisitTwice(from: Node, path: Path): List<Path> {
        if (from == end()) {
            return listOf(path)
        }

        val toVisit = when {
            path.hasVisitedSmallCaveTwice() -> from.neighbors - path.smallCaves()
            else -> from.neighbors - start()
        }

        return when {
            toVisit.isEmpty() -> listOf() // no valid paths
            else -> toVisit.flatMap { toEndVisitTwice(it, path.amend(it))  }
        }
    }


    fun start(): Node = nodes.find { it.name == "start" }!!
    fun end(): Node = nodes.find { it.name == "end" }!!

    private fun findOrAdd(nodeName: String) =
        nodes.find { it.name == nodeName } ?: Node(nodeName).also { nodes.add(it) }
}
