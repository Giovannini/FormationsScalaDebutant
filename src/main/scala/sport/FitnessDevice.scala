package sport

import doodle.core.{Color, Image, Rectangle}


sealed trait FitnessDevice


case class Barbell(load: Int, length: Int) extends FitnessDevice {
  def weigh: Barbell = Barbell(load + 10, length + 20)
  def lighten: Option[Barbell] =
    if (load <= 15 || length <= 100) None
    else Some(Barbell(load - 10, length - 20))

  def image: Image = {
    val weight = Barbell.weight(load)
    val bar = Barbell.bar(length)
    weight beside bar beside weight
  }
}

object Barbell {
  def bar(l: Int): Image = Rectangle(l, 15) fillColor Color.grey
  def weight(w: Int): Image = Rectangle(w, 100) fillColor Color.black
}



case class Mat(width: Int, length: Int) extends FitnessDevice {
  def image: Image = Rectangle(width, length) fillColor Color.blue
  def area: Int = width * length

  def smaller: Option[Mat] =
    if (width <= 50 || length <= 100) None
    else Some(Mat(width - 10, length - 20))

}

object FitnessDevice {
  def fitnessDeviceImage(fitnessDevice: FitnessDevice): Image = {
    fitnessDevice match {
      case b: Barbell => b.image
      case Mat(l, w) => Mat(l, w).image
    }
  }

  def smallerButLargeEnough(mat: Mat): Option[Int] = {
    mat
      .smaller
      .map(_.area)
      .filter(_ > 1000)
  }
}


