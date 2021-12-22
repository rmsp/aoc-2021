package nl.rmspek.aoc2021.day9

class Surroundings (
    val t: Pair<Int, Int>?,
    val r: Pair<Int, Int>?,
    val b: Pair<Int, Int>?,
    val l: Pair<Int, Int>?
): Iterable<Pair<Int, Int>?> {
    override fun iterator(): Iterator<Pair<Int, Int>?> = iterator {
        yield(t)
        yield(r)
        yield(b)
        yield(l)
    }
}
