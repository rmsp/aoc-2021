package nl.rmspek.aoc2021.day2

fun parseDirection(str: String) = when(str) {
    "up" -> Direction.UP
    "down" -> Direction.DOWN
    "forward" -> Direction.FORWARD
    else -> throw Error("Invalid Direction $str")
}

enum class Direction {
    UP,
    DOWN,
    FORWARD;

}
