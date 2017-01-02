package sport

import doodle.jvm._

object Main extends App {

  val myBarbel = Barbell(20, 100)

  def drawBarbel(n: Int, barbell: Barbell): Unit = {
    val lighterBarbell = barbell.lighten
    draw(lighterBarbell.image)
    drawBarbel(n-1, lighterBarbell)
  }

  val myMat = Mat(50, 100)

//  draw(FitnessDevice.fitnessDeviceImage(myBarbel))
//  draw(FitnessDevice.fitnessDeviceImage(myMat))

}
