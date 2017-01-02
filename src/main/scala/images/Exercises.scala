package images

import doodle.core._
import doodle.jvm._

object Exercises extends App {
  def spiral(n: Int): Image = {
    val dist = 20 * n
    val angle = Angle.degrees(40 * n)
    val x = dist * angle.cos
    val y = dist * angle.sin
    val circle = Circle(5 * n).at(x, y)
    if (n == 1) circle else circle on spiral(n - 1)
  }

  draw(spiral(10))

}
