package nl.rmspek.aoc2021.day2

class Ship(var pos: Int = 0, var depth: Int = 0, var aim: Int = 0) {
    fun move(move: Move) {
        when(move.direction) {
            Direction.UP -> aim -= move.amount
            Direction.DOWN -> aim += move.amount
            Direction.FORWARD -> {
                pos += move.amount
                depth += aim * move.amount
            }
        }
    }

    override fun toString() = "Space($pos, $depth, $aim)"
}
