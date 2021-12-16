package nl.rmspek.aoc2021.day1

class DepthWindow (private val nums: List<Int>) : List<Int> by nums

fun depthWindowsFromList(list: List<Int>, windowSize: Int): List<DepthWindow> =
    indexes(list, windowSize).map {
        DepthWindow(list.subList(it, it+windowSize))
    }

private fun indexes(list: List<Int>, windowSize: Int) = (0..(list.size - windowSize))
