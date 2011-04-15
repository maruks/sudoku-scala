import org.scalatest.WordSpec
import java.io.File
import scala.collection.immutable.VectorBuilder

class SudokuIOSpec extends WordSpec {
  
  "SudokuIO" should {
  
    "read puzzle file" in {
      val io = new SudokuIO()
      val p = io.readFile(new File("src/test/resources/puzzle1.txt"))

      assert(p.size==9*9)

      val b = new VectorBuilder[Int]()      
      for (i <- 0 to 8) b += i
      val vec = b.result

      for (g <- p.grouped(9)) {
	assert(g==vec)      
      }
    }
  }
}
