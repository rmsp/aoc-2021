package nl.rmspek.aoc2021.day12

import com.sun.corba.se.impl.orbutil.graph.Graph

class Node(val name: String) {
    val neighbors = mutableSetOf<Node>()

    fun isBig() = name.first().isUpperCase()

    override fun toString() = "$name(${neighbors.count()})"
    override fun equals(other: Any?) = (other is Node) && other.name == name
}
