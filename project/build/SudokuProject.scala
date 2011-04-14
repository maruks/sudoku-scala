import sbt._

class SudokuProject(info: ProjectInfo) extends DefaultProject(info)
{
  val scalatest = "org.scalatest" % "scalatest" % "1.3" % "test->default"
  val junit = "junit" % "junit" % "4.8.2" % "test->default"
}
