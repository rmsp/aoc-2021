package nl.rmspek.aoc2021.util

import java.math.BigInteger

fun CharSequence.tally(): Map<Char, Int> {
    val result = mutableMapOf<Char, Int>()
    this.forEach {
        result.compute(it) { k, v -> if (v == null || k == null) 1 else v + 1}
    }
    return result
}

fun CharSequence.bigTally(): Map<Char, BigInteger> {
    val result = mutableMapOf<Char, BigInteger>()
    this.forEach {
        result.compute(it) { k, v -> if (v == null || k == null) BigInteger.ONE else v + BigInteger.ONE }
    }
    return result
}

fun <T> Sequence<T>.tally(): Map<T, Int> {
    val result = mutableMapOf<T, Int>()
    this.forEach {
        result.compute(it) { k, v -> if (v == null || k == null) 1 else v + 1}
    }
    return result
}

fun <T> Sequence<T>.bigTally(): Map<T, BigInteger> {
    val result = mutableMapOf<T, BigInteger>()
    this.forEach {
        result.compute(it) { k, v -> if (v == null || k == null) BigInteger.ONE else v + BigInteger.ONE }
    }
    return result
}
