class TurnManager(private val players: Pair<Player, Player>, private val serviceResults: List<ServiceResult>) {
    fun next(): Player = when {
        serviceResults.isEmpty() -> players.first
        serviceResults.count() == 1 -> players.first
        else -> {
            val pastServiceRecords = serviceResults.takeLast(2)
            when {
                pastServiceRecords[1].playerNumber == 1 && pastServiceRecords[2].playerNumber == 1 -> players.second
                pastServiceRecords[1].playerNumber == 1 && pastServiceRecords[2].playerNumber == 2 -> players.second
                pastServiceRecords[1].playerNumber == 2 && pastServiceRecords[2].playerNumber == 1 -> players.first
                else -> players.first
            }
        }
    }
}

data class Player(val playerNumber: Int) {
    fun serve(): ServiceResult =
        when {
            (0..100).random() % 2 == 0 && playerNumber == 1 -> ServiceResult(1, 0, playerNumber)
            (0..100).random() % 2 == 0 && playerNumber == 2 -> ServiceResult(0, 1, playerNumber)
            else -> ServiceResult(0, 0, playerNumber)
        }
}

data class ServiceResult(val playerIScore: Int, val playerIIScore: Int, val playerNumber: Int)