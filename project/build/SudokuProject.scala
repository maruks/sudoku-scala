import sbt._

class SudokuProject(info: ProjectInfo) extends DefaultProject(info) with assembly.AssemblyBuilder
{
  val scalatest = "org.scalatest" % "scalatest_2.9.0" % "1.4.1" % "test->default"
  val junit = "junit" % "junit" % "4.8.2" % "test->default"
}
