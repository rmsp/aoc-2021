package nl.rmspek.aoc2021.day4

class Game (private val boards: List<Board>) {
    fun resolveWinner(input: Input): Result {
        input.input.forEach { input ->
            val winningBoards = boards.filter { it.check(input) }
            if (winningBoards.any()) {
                if (winningBoards.size > 1) throw Error("Multiple winners")
                return Result(input, winningBoards.first().sumEmpty())
            }
        }

        throw Error("No winners")
    }

    fun resolveLoser(input: Input): Result = recurseLoser(input, 0, boards)

    private fun recurseLoser(input: Input, inputIdx: Int, _boards: List<Board>): Result {
        val restBoards = _boards - _boards.filter { it.check(input.input[inputIdx]) }
        return if (restBoards.size == 1) {
            val board = restBoards.first()
            Result(playUntilWon(input, inputIdx, board), board.sumEmpty())
        } else {
            recurseLoser(input, inputIdx + 1, restBoards)
        }
    }

    private fun playUntilWon(input: Input, inputIdx: Int, board: Board): Int {
        if (board.winner()) return input.input[inputIdx]
        (inputIdx + 1 until input.input.size).forEach {
            if (board.check(input.input[it])) {
                return input.input[it]
            }
        }

        throw Error("Does not win")
    }

}

const val X_SZ = 5
const val Y_SZ = 5
