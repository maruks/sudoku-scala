package sudoku

import java.io.File

object Main {
  def main(args: Array[String]):Unit = {
    if (args.length!=1) {
      println("Usage SudokuSolver <filename>")
      System.exit(1)
    }
    val p = SudokuIO.readFile(new File(args(0)))
    val sol = SudokuSolver.solve(p)
    SudokuIO.writeFile(System.out,sol)
  }
}
