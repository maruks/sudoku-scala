package sudoku

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers
import java.io.File
import scala.collection.immutable.VectorBuilder

class SudokuSolverSpec extends WordSpec with ShouldMatchers {

  "SudokuSolver" should {

    val p = SudokuIO.readFile(new File("src/test/resources/puzzle2.txt"))

    "select first row" in {
      val set = Set(2, 0, 8, 6, 7)
      SudokuSolver.selectRow(p, 0) should equal (set)
      SudokuSolver.selectRow(p, 3) should equal (set)
      SudokuSolver.selectRow(p, 8) should equal (set)
    }
    "select second row" in {
      val set = Set(3, 0, 2, 5)
      SudokuSolver.selectRow(p, 9) should equal (set)
      SudokuSolver.selectRow(p, 14) should equal (set)
      SudokuSolver.selectRow(p, 17) should equal (set)
    }
    "select last row" in {
      val set = Set(2, 0, 6, 8, 9)
      SudokuSolver.selectRow(p, 72) should equal (set)
      SudokuSolver.selectRow(p, 76) should equal (set)
      SudokuSolver.selectRow(p, 80) should equal (set)
    }
    "select first column" in {
      val set = Set(2, 0, 5, 9)
      SudokuSolver.selectColumn(p, 0) should equal (set)
      SudokuSolver.selectColumn(p, 27) should equal (set)
      SudokuSolver.selectColumn(p, 72) should equal (set)
    }
    "select second column" in {
      val set = Set(0, 3, 6)
      SudokuSolver.selectColumn(p, 1) should equal (set)
      SudokuSolver.selectColumn(p, 28) should equal (set)
      SudokuSolver.selectColumn(p, 73) should equal (set)
    }
    "select last column" in {
      val set = Set(7, 0, 3, 4, 9)
      SudokuSolver.selectColumn(p, 8) should equal (set)
      SudokuSolver.selectColumn(p, 35) should equal (set)
      SudokuSolver.selectColumn(p, 80) should equal (set)
    }
    "select upper left square" in {
      val set = Set(2, 3, 5, 6, 0)
      SudokuSolver.selectSquare(p, 0) should equal (set)
      SudokuSolver.selectSquare(p, 10) should equal (set)
      SudokuSolver.selectSquare(p, 20) should equal (set)
    }
    "select middle right square" in {
      val set = Set(9, 3, 1, 0)
      SudokuSolver.selectSquare(p, 33) should equal (set)
      SudokuSolver.selectSquare(p, 43) should equal (set)
      SudokuSolver.selectSquare(p, 53) should equal (set)
    }
    "select bottom right square" in {
      val set = Set(2, 4, 1, 9, 0)
      SudokuSolver.selectSquare(p, 60) should equal (set)
      SudokuSolver.selectSquare(p, 61) should equal (set)
      SudokuSolver.selectSquare(p, 62) should equal (set)
      SudokuSolver.selectSquare(p, 69) should equal (set)
      SudokuSolver.selectSquare(p, 70) should equal (set)
      SudokuSolver.selectSquare(p, 71) should equal (set)
      SudokuSolver.selectSquare(p, 78) should equal (set)
      SudokuSolver.selectSquare(p, 79) should equal (set)
      SudokuSolver.selectSquare(p, 80) should equal (set)
    }

    "solve third sudoku" in {
      val p = SudokuIO.readFile(new File("src/test/resources/puzzle3.txt"))
      val s = SudokuIO.readFile(new File("src/test/resources/sol3.txt"))

      val sol = SudokuSolver.solve(p).getOrElse(Vector.empty)
      sol should have length (81)
      s should equal (sol)
    }

    "report first sudoku unsolvable" in {
      val p = SudokuIO.readFile(new File("src/test/resources/puzzle1.txt"))
      val sol = SudokuSolver.solve(p)
      sol should be ('empty)
    }
  }
}
