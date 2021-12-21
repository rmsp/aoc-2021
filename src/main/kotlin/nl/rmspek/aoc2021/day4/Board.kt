package nl.rmspek.aoc2021.day4

import java.util.*

class Board(private val rows: List<Row>) {
    fun check(input: Int): Boolean {
        return rows.any { it.check(input) } || columnWinner()
    }

    fun sumEmpty(): Int = rows.flatMap { it.boxes }.filter { !it.checked }.sumBy { it.value }
    fun winner(): Boolean = rows.any { it.winner() } || columnWinner()

    private fun columnWinner() = (0 until Y_SZ).any(this::columnWinnerAt)
    private fun columnWinnerAt(colIndex: Int) = rows.all { it.boxes[colIndex].checked }
}

fun parseBoards(scan: Scanner): List<Board> {
    val result = mutableListOf<Board>()
    while (true){
        when (val board = parseBoard(scan)) {
            null -> return result
            else -> result.add(board)
        }
    }
}

private fun parseBoard(scan: Scanner): Board? {
    if (!scan.hasNextLine()) return null

    return Board((0 until Y_SZ).map { parseRow(scan.nextLine()) }).also { if (scan.hasNextLine()) scan.nextLine() }
}
