package nl.rmspek.aoc2021.day2

class Space(var hPos: Int = 0, var vPos: Int = 0) {
    fun move(move: Move) {
        when(move.direction) {
            Direction.UP -> hPos -= move.distance
            Direction.DOWN -> hPos += move.distance
            Direction.FORWARD -> vPos += move.distance
        }
    }

    override fun toString() = "Space($hPos, $vPos)"
}
