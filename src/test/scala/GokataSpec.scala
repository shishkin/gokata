import org.scalatest._


class GokataSpec extends FlatSpec with Matchers {

  "The game" should "start with a square board of all positions available" in {
    val side = 5
    val board = new Game(size = side)
    board.availablePositions should have size side * side
  }

  it should "be started by white" in {
    val game = new Game()
    game.currentPlayer should equal(White)
  }

  it should "alternate players" in {
    val game = new Game()
    game.currentPlayer should equal(White)
    game.play(2, 3)

    game.currentPlayer should equal(Black)

    game.play(3, 2)
    game.currentPlayer should equal(White)
  }

  it should "decrement available positions after a move" in {
    val game = new Game()
    val initialAvailablePositions = game.availablePositions.length
    game.play(2,3)
    game.availablePositions should have size (initialAvailablePositions - 1)
  }

  "The player" should "be able to set its position on 2 3" in {
    val game = new Game()
    game.play(2, 3)

    game.getPlayerAtPosition(2, 3) should equal(White)
  }

}
