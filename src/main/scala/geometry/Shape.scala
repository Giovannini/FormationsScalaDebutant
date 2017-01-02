package geometry

sealed trait Shape

case class Circle(radius: Int) extends Shape
sealed trait Parallelogram extends Shape {
  val width: Int
  val length: Int
}
case class Rectangle(width: Int, length: Int) extends Parallelogram
case class IsocelTriangle(width: Int, height: Int) extends Shape

object Toto {

}


