import doodle.core._
import doodle.jvm._

object Thomas extends App {
  val smallWeight = Rectangle(15, 100) fillColor Color.black
  val bigWeight = Rectangle(30, 100) fillColor Color.black
  val bar = Rectangle(200, 15) fillColor Color.grey

  def weight(w: Int): Image = Rectangle(w, 100) fillColor Color.black
  def barbell(weight: Image): Image = weight beside bar beside weight

  def unit: Image = barbell(weight(15))

  def barbells(n: Int): Image =
    if (n == 1) unit
    else unit above barbells(n - 1)

  def circles(n: Int): Image = {
    if (n == 1) Circle(10) else Circle(n * 10) on circles(n-1)
  }

  def circlesSeq(n: Int): Seq[Image] = n match {
    case 0 => Seq.empty[Image]
    case a => Circle(a * 10) +: circlesSeq(a - 1)
  }

  def circlesMap(n: Int): Seq[Image] = (1 to n by 10).map(n => Circle(n))


  val emptyImage = Circle(0).lineWidth(0)

  @scala.annotation.tailrec
  def circlesSeqTR(n: Int, images: Seq[Image]): Seq[Image] = (n, images) match {
    case (1, Nil) => Circle(10) +: images
    case (1, is) => Circle(10) +: images
    case (a, is) =>
      val myCircle = Circle(a * 10)
      circlesSeqTR(a -1, myCircle +: images)

  }

  def spiral(n: Int): Image = {
    val dist = 20 * n
    val angle = Angle.degrees(40 * n)
    val x = dist * angle.cos
    val y = dist * angle.sin
    val circle = Circle(5 * n).at(x, y)
    if (n == 1) circle else circle on spiral(n - 1)
  }

  def spiralSeq(n: Int): Seq[Image] = {
    val dist = 20 * n
    val angle = Angle.degrees(40 * n)
    val x = dist * angle.cos
    val y = dist * angle.sin
    val circle = Circle(5 * n).at(x, y)

    n match {
      case 1 => Seq(circle)
      case a => circle +: spiralSeq(a - 1)
    }
  }

  def spiralMap(n: Int): Seq[Image] = (1 to n).map { i =>
    val dist = 20 * i
    val angle = Angle.degrees(40 * i)
    val x = dist * angle.cos
    val y = dist * angle.sin
    Circle(5 * i).at(x, y)
  }


  def stack(images: Seq[Image]): Image = images match {
    case image +: Nil => image
    case image +: imageTails => image on stack(imageTails)
  }

  def stackFold(images: Seq[Image]): Image = images.foldLeft(emptyImage)(
    (acc, image) => acc on image
  )
  def stackFold2(images: Seq[Image]): Image =
    images.foldLeft(emptyImage)(_ on _)



  def sierpinski(n: Int): Image =  {
    val unit = Triangle(15, 15) fillColor Color.black
    if (n == 1) unit else {
      val base = sierpinski(n - 1)

      base above (base beside base)
    }
  }

  class SierpinskiAnimation(i: Int, max: Int, hackTimer: Int) extends Animation {
    override def animate: Animation = {
      val newI = (i + (hackTimer/200)) % max + 1
      new SierpinskiAnimation(newI, max, (hackTimer + 1) % 201)
    }

    override def draw: Image = sierpinski(i)
  }

  // animate(new SierpinskiAnimation(6, 6, 0))

  // FitnessDevice.fitnessDeviceImage(Barbell(30, 100))

  Seq(Seq(1, 2, 3), Seq(4, 5, 6))

  draw(stackFold2(spiralMap(10)))
}

