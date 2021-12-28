package nl.rmspek.aoc2021.day13

import nl.rmspek.aoc2021.util.readDayInput
import java.util.*

fun parsePoints(scan: Scanner): Set<Pair<Int, Int>> {
    val points = mutableSetOf<Pair<Int, Int>>()
    while(scan.hasNextLine()) {
        when (val line = scan.nextLine()) {
            "" -> return points
            else -> line.split(",").let { points.add(Pair(it[0].toInt(), it[1].toInt())) }
        }
    }

    throw Error("no folds")
}

fun parseFolds(scan: Scanner): List<Pair<Char, Int>> {
    val folds = mutableListOf<Pair<Char, Int>>()
    while(scan.hasNextLine()) {
        val parts = scan.nextLine().split("=")
        folds.add(Pair(parts[0].last(), parts[1].toInt()))
    }
    return folds
}

fun main() {
    val scanner = Scanner(readDayInput(13))
    var points = parsePoints(scanner)
    val folds = parseFolds(scanner)
    doFold(points, folds, 1)
}

fun doFold(_points: Set<Pair<Int, Int>>, folds: List<Pair< Char, Int>>, count: Int?): Set<Pair<Int, Int>> {
    var points = _points
    folds.take(count ?: folds.size).forEach { fold ->
        points = when (fold.first) {
            'y' -> foldVertical(points, fold.second)
            'x' -> foldHorizontal(points, fold.second)
            else -> throw Error("Cant fold like this")
        }
        println(points.count())
    }

    return points
}

private fun foldVertical(points: Set<Pair<Int, Int>>, y: Int): Set<Pair<Int, Int>> {
    val (top, bottom) = points.partition { it.second < y }
    return mutableSetOf<Pair<Int, Int>>().also {
        it.addAll(top + bottom.map { Pair(it.first, y - (it.second - y)) })
    }
}

private fun foldHorizontal(points: Set<Pair<Int, Int>>, x: Int): Set<Pair<Int, Int>> {
    val (left, right) = points.partition { it.first < x }
    return mutableSetOf<Pair<Int, Int>>().also {
        it.addAll(left + right.map { Pair(x - (it.first - x), it.second) })
    }
}
