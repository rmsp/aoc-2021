package nl.rmspek.aoc2021.day3

import nl.rmspek.aoc2021.util.readStringList
import kotlin.math.pow


fun main() {
    val codeList = readStringList(3)
    val report = DiagnosticReport(codeList.first().length)
    codeList.forEach { report.addCode(it) }
    var gamma = 0 // most common bit in the pos
    var epsilon = 0 // least common bit in the pos
    report.diagnostics.forEachIndexed { idx, it ->
        val positiveCount = it.positiveCount
        val cutoff = report.addedCodes / 2
        when {
            positiveCount == cutoff -> throw Error("Count is same as cutoff")
            positiveCount > cutoff -> gamma += 2.0.pow(report.diagnostics.size - 1- idx).toInt() // 1 is most common 0 is least common
            positiveCount < cutoff -> epsilon += 2.0.pow(report.diagnostics.size - 1 - idx).toInt() // 0 is most common 1 is least common
        }
    }

    print(report)
    println(gamma)
    println(epsilon)
    println(epsilon * gamma)
}

private fun print(report: DiagnosticReport) {
    println("Diagnostics")
    println(report.addedCodes)
    report.diagnostics.forEach { println(it) }
}

// g = 100100101010
// e = 011011010101
