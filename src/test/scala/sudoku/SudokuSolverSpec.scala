import org.scalatest.WordSpec
import java.io.File
import scala.collection.immutable.VectorBuilder

class SudokuSolverSpec extends WordSpec {

  "SudokuSolver" should {

    val io = new SudokuIO()
    val p = io.readFile(new File("src/test/resources/puzzle2.txt"))

    "select first row" in {
      val set = Set(2, 0, 8, 6, 7)
      assert(SudokuSolver.selectRow(p,0) == set)
      assert(SudokuSolver.selectRow(p,3) == set)
      assert(SudokuSolver.selectRow(p,8) == set)
    }
    "select second row" in {
      val set = Set(3, 0, 2, 5)
      assert(SudokuSolver.selectRow(p,9) == set)
      assert(SudokuSolver.selectRow(p,14) == set)
      assert(SudokuSolver.selectRow(p,17) == set)
    }
    "select last row" in {
      val set = Set(2, 0, 6, 8, 9)
      assert(SudokuSolver.selectRow(p,72) == set)
      assert(SudokuSolver.selectRow(p,76) == set)
      assert(SudokuSolver.selectRow(p,80) == set)
    }
    "select first column" in {
      val set = Set(2, 0, 5, 9)
      assert(SudokuSolver.selectColumn(p,0) == set)
      assert(SudokuSolver.selectColumn(p,27) == set)
      assert(SudokuSolver.selectColumn(p,72) == set)
    }
    "select second column" in {
      val set = Set(0, 3, 6)
      assert(SudokuSolver.selectColumn(p,1) == set)
      assert(SudokuSolver.selectColumn(p,28) == set)
      assert(SudokuSolver.selectColumn(p,73) == set)
    }
    "select last column" in {
      val set = Set(7, 0, 3, 4, 9)
      assert(SudokuSolver.selectColumn(p,8) == set)
      assert(SudokuSolver.selectColumn(p,35) == set)
      assert(SudokuSolver.selectColumn(p,80) == set)
    }
    "select upper left square" in {
      val set = Set(2, 3, 5, 6, 0)
      assert(SudokuSolver.selectSquare(p,0) == set)
      assert(SudokuSolver.selectSquare(p,10) == set)
      assert(SudokuSolver.selectSquare(p,20) == set)
    }
    "select middle right square" in {
      val set = Set(9, 3, 1, 0)
      assert(SudokuSolver.selectSquare(p,33) == set)
      assert(SudokuSolver.selectSquare(p,43) == set)
      assert(SudokuSolver.selectSquare(p,53) == set)
    }
    "select bottom right square" in {
      val set = Set(2, 4, 1, 9, 0)
      assert(SudokuSolver.selectSquare(p,60) == set)
      assert(SudokuSolver.selectSquare(p,61) == set)
      assert(SudokuSolver.selectSquare(p,62) == set)
      assert(SudokuSolver.selectSquare(p,69) == set)
      assert(SudokuSolver.selectSquare(p,70) == set)
      assert(SudokuSolver.selectSquare(p,71) == set)
      assert(SudokuSolver.selectSquare(p,78) == set)
      assert(SudokuSolver.selectSquare(p,79) == set)
      assert(SudokuSolver.selectSquare(p,80) == set)
    }
    "solve sudoku" in {
      
      val sol = SudokuSolver.solve(p)
    }
  }
}
