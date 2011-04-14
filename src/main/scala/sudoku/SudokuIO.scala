import java.io._
import io.Source
import scala.collection.immutable.VectorBuilder

class SudokuIO {
  
  def readFile(file: File): Vector[Int] = {
    val b = new VectorBuilder[Int]()
    b.sizeHint(9*9)
    Source.fromFile(file).getLines().foreach(line => b++= line.split(',').map(s => Integer.parseInt(s.trim)))
    b.result()
  }

  def writeFile(file: File, s: Vector[Int])= {
    val out = new OutputStreamWriter(new FileOutputStream(file))
    for (g <- s.grouped(9)) {
      val str = (g.head.toString() /: g.tail)((a, b) => a + ',' + b)
      out.write(str)
    }
    out.close  
  }
}
