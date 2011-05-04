package sudoku

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers
import java.io.File
import scala.collection.immutable.VectorBuilder

class SudokuIOSpec extends WordSpec with ShouldMatchers {
  
  "SudokuIO" should {
  
    "read puzzle file" in {
      
      val p = SudokuIO.readFile(new File("src/test/resources/puzzle1.txt"))

      p should have size (9*9)

      val b = new VectorBuilder[Int]()      
      for (i <- 0 to 8) b += i
      val vec = b.result

      for (g <- p.grouped(9)) {
	g should equal (vec)      
      }
    }
  }
}
