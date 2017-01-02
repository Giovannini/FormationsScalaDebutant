package course

sealed trait DifficultyLevel
case object Beginner extends DifficultyLevel
case object Intermediate extends DifficultyLevel
case class Advanced() extends DifficultyLevel

case class Course(name: String, difficulty: DifficultyLevel)

object Toto {

  val course1 = Course("Course1", Advanced())
  val course2 = Course("Course2", Intermediate)

}
