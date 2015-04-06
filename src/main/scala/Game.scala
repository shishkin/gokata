
sealed trait Player

case object White extends Player

case object Black extends Player

class Game(size: Int = 8) {

  private var positions = Array.ofDim[Int](size * size)

  private var player: Player = White

  def availablePositions  = {
    positions
  }

  def play(x: Int, y: Int): Unit = {
    positions = positions.tail
    player = player match {
      case White => Black
      case Black => White
    }
  }

  def currentPlayer: Player = player

  def getPlayerAtPosition(x: Int, y: Int) = White
}
