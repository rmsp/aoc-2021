package nl.rmspek.aoc2021.day3

class DiagnosticReport(codeLength: Int) {
    private val everyCodeIndex = (0 until codeLength)
    val positionDiagnostics: List<PositionEntry> = everyCodeIndex.map { PositionEntry(it) }

    fun analyzeAllPositions(code: Code) {
        everyCodeIndex.forEach { analyzePosition(it + 1, code) }
    }

    fun analyzePosition(position: Int, code: Code) {
        byPosition(position).positionCodes.computeIfAbsent(code.atPosition(position)) { mutableListOf() }.add(code)
    }

    fun analyzePosition(position: Int, codes: List<Code>) {
        codes.forEach { analyzePosition(position, it) }
    }

    fun byPosition(position: Int) = positionDiagnostics[position - 1]
}
