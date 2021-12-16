package nl.rmspek.aoc2021.day3

class DiagnosticReport(codeLength: Int) {
    val diagnostics: List<ReportEntry> = (0 until codeLength).map { ReportEntry(it) }
    var addedCodes = 0

    fun addCode(code: String) {
        code.forEachIndexed { idx, it ->
            if (it == '1') diagnostics[idx].positiveCount++
        }

        addedCodes++
    }
}
