package sudoku

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers
import java.io.File
import scala.collection.immutable.VectorBuilder

class SudokuSolverSpec extends WordSpec with ShouldMatchers {

  "SudokuSolver" should {

    val p = SudokuIO.readFile(new File("src/test/resources/puzzle2.txt"))

    val indexFun = Map('row -> SudokuSolver.selectRow _, 'column -> SudokuSolver.selectColumn _, 'square -> SudokuSolver.selectSquare _)

    def select(s : Symbol, p : Vector[Int], i : Int) = (indexFun(s))(i).map(p(_)).toSet[Int] 

    "select first row" in {
      val set = Set(2, 0, 8, 6, 7)
      select('row, p, 0) should equal (set)
      select('row, p, 3) should equal (set)
      select('row, p, 8) should equal (set)
    }
    "select second row" in {
      val set = Set(3, 0, 2, 5)
      select('row, p, 9) should equal (set)
      select('row, p, 14) should equal (set)
      select('row, p, 17) should equal (set)
    }
    "select last row" in {
      val set = Set(2, 0, 6, 8, 9)
      select('row, p, 72) should equal (set)
      select('row, p, 76) should equal (set)
      select('row, p, 80) should equal (set)
    }
    "select first column" in {
      val set = Set(2, 0, 5, 9)
      select('column, p, 0) should equal (set)
      select('column, p, 27) should equal (set)
      select('column, p, 72) should equal (set)
    }
    "select second column" in {
      val set = Set(0, 3, 6)
      select('column, p, 1) should equal (set)
      select('column, p, 28) should equal (set)
      select('column, p, 73) should equal (set)
    }
    "select last column" in {
      val set = Set(7, 0, 3, 4, 9)
      select('column, p, 8) should equal (set)
      select('column, p, 35) should equal (set)
      select('column, p, 80) should equal (set)
    }
    "select upper left square" in {
      val set = Set(2, 3, 5, 6, 0)
      select('square, p, 0) should equal (set)
      select('square, p, 10) should equal (set)
      select('square, p, 20) should equal (set)
    }
    "select middle right square" in {
      val set = Set(9, 3, 1, 0)
      select('square, p, 33) should equal (set)
      select('square, p, 43) should equal (set)
      select('square, p, 53) should equal (set)
    }
    "select bottom right square" in {
      val set = Set(2, 4, 1, 9, 0)
      select('square, p, 60) should equal (set)
      select('square, p, 61) should equal (set)
      select('square, p, 62) should equal (set)
      select('square, p, 69) should equal (set)
      select('square, p, 70) should equal (set)
      select('square, p, 71) should equal (set)
      select('square, p, 78) should equal (set)
      select('square, p, 79) should equal (set)
      select('square, p, 80) should equal (set)
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
