package gol


case class GameOfLife(matrix: Vector[Vector[Int]]) {

  def next: GameOfLife = ???

  override def toString: String = {
    matrix.map(_.mkString(" ")).mkString("\n")
  }

}

object GameOfLife extends App {

  def testRule(x: Int, y: Int, matrix: Vector[Vector[Int]]) = {
    val value = matrix(x)(y)
    val newValue = if (value == 1) 0
    else 1
    matrix
      ???
  }

  def test = GameOfLife(
    Vector(
      Vector(1, 1, 0),
      Vector(0, 0, 0),
      Vector(0, 0, 0)
    )
  )

}
