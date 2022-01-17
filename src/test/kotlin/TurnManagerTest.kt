import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TurnManagerTest : DescribeSpec() {

    init {

        describe("TurnManager") {

            it("should return first player if its a first serve of the game") {
                val turnManager = TurnManager(Pair(Player(1), Player(2)), emptyList())
                turnManager.next() shouldBe Player(1)
            }

            describe("should allow player to serve twice") {

                it("should return same player in a row if only one serve is done") {
                    val serviceResults = listOf(
                        ServiceResult(1, 0, 1)
                    )
                    val turnManager = TurnManager(Pair(Player(1), Player(2)), serviceResults)
                    turnManager.next() shouldBe Player(1)
                }
            }
        }
    }
}