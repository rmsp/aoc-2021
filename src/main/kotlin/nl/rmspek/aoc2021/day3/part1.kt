package nl.rmspek.aoc2021.day3

import nl.rmspek.aoc2021.util.readStringList
import kotlin.math.pow


fun main() {
    val codeList = parseInput(readStringList(3))
    val codeLength = codeList.first().value.length
    val report = DiagnosticReport(codeLength)
    codeList.forEach { report.analyzeAllPositions(it) }
    var gamma = 0 // most common bit in the pos
    var epsilon = 0 // least common bit in the pos
    report.positionDiagnostics.forEach {
        val positiveCount = it.tally('1')
        val cutoff = it.codeCount() / 2
        when {
            positiveCount == cutoff -> throw Error("Count is same as cutoff")
            positiveCount > cutoff -> gamma += 2.0.pow(it.exponent(codeLength)).toInt()
            positiveCount < cutoff -> epsilon += 2.0.pow(it.exponent(codeLength)).toInt()
        }
    }

    print(report)
    println(gamma)
    println(epsilon)
    println(epsilon * gamma)
}

private fun print(report: DiagnosticReport) {
    println("Diagnostics")
    report.positionDiagnostics.forEach { println(it) }
}

// g = 100100101010
// e = 011011010101

// 2346
// 1749
// 4103154
