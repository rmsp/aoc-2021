package nl.rmspek.aoc2021.day3

inline class Code(val value: String)

fun parseInput(list: List<String>): List<Code> = list.map { Code(it) }

fun Code.atPosition(position: Int) = value[position - 1]
fun inverseCodeBit(codeBit: Char) = when (codeBit) {
    '0' -> '1'
    '1' -> '0'
    else -> throw Error("Could not invert code bit")
}
fun Code.decimal() = Integer.parseInt(value, 2)
