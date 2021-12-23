package nl.rmspek.aoc2021.day11

inline class Octopus(val energyLevel: Int)

fun Octopus.step() = Octopus(this.energyLevel + 1)
