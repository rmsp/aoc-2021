package nl.rmspek.aoc2021.day4

class Game (private val boards: List<Board>) {
    fun resolve(input: Input): Result {
        input.input.forEach { input ->
            val winningBoards = boards.filter { it.check(input) }
            if (winningBoards.any()) {
                if (winningBoards.size > 1) throw Error("Multiple winners")
                return Result(input, winningBoards.first().sumEmpty())
            }
        }

        throw Error("No winners")
    }
}

const val X_SZ = 5
const val Y_SZ = 5
