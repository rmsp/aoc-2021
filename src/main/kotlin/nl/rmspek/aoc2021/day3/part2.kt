package nl.rmspek.aoc2021.day3

import nl.rmspek.aoc2021.util.readStringList

fun main() {
    val codeList = parseInput(readStringList(3))
    //val codeList = parseInput(readStringList(3, "test"))

    val o2Code = analyzeO2(1, codeList)
    val co2Code = analyzeCo2(1, codeList)
    println(o2Code.decimal())
    println(co2Code.decimal())
    println(o2Code.decimal() * co2Code.decimal())
}

fun analyzeO2(position: Int, codeList: List<Code>): Code {
    if (codeList.size == 1) return codeList.first()

    val report = DiagnosticReport(codeList.first().value.length)
    report.analyzePosition(position, codeList)
    val positionReport = report.byPosition(position)
    return analyzeO2(
        position + 1,
        if (positionReport.commonalityClashes()) positionReport.positionCodes['1']!! else positionReport.mostCommonValue().second
    )
}

fun analyzeCo2(position: Int, codeList: List<Code>): Code {
    if (codeList.size == 1) return codeList.first()

    val report = DiagnosticReport(codeList.first().value.length)
    report.analyzePosition(position, codeList)
    val positionReport = report.byPosition(position)
    return analyzeCo2(
        position + 1,
        if (positionReport.commonalityClashes()) positionReport.positionCodes['0']!! else positionReport.leastCommonValue().second
    )
}



// fun main() {
//
//     val codeList = parseInput(readStringList(3))
//     val codeLength = codeList.first().value.length
//     var o2Result: Code? = null
//     var co2Result: Code? = null
//
//     var position = 1
//     do {
//         var positionReport = DiagnosticReport(codeLength)
//         val (intermediateO2, intermediateCo2) = analyze(position, codeList, positionReport)
//         if (o2Result == null && intermediateO2.hasResult()) {
//             o2Result = intermediateO2.resultingCode()
//         }
//
//         if (co2Result == null && intermediateCo2.hasResult()) {
//             co2Result = intermediateCo2.resultingCode()
//         }
//
//         position++
//     } while(o2Result == null && co2Result == null)
//
//     println(o2Result)
//     println(co2Result)
// }
//
// private fun analyze(position: Int, codeList: List<Code>, positionReport: DiagnosticReport): Pair<AnalysisIntermediateResult, AnalysisIntermediateResult> {
//     val codeLength = codeList.first().value.length
//     codeList.forEach { code -> positionReport.analyzePosition(position, code) }
//
//     val positionCodes = positionReport.byPosition(position)
//     val mostCommon = positionCodes.mostCommonValue()
//     return when (mostCommon?.first) {
//         null -> {
//             Pair(fromPositionEntry(positionCodes, '1'), fromPositionEntry(positionCodes, '0'))
//         }
//         '0', '1' -> {
//             Pair(
//                 fromPositionEntry(positionCodes, mostCommon.first),
//                 fromPositionEntry(positionCodes, inverseCodeBit(mostCommon.first))
//             )
//         }
//         else -> throw Error("Don't understand value ${mostCommon.first}")
//     }
// }
