package nl.rmspek.aoc2021.day9

class Surroundings (val t: Int, val r: Int, val b: Int, val l: Int): Iterable<Int> {
    override fun iterator(): Iterator<Int> = iterator {
        yield(t)
        yield(r)
        yield(b)
        yield(l)
    }
}
