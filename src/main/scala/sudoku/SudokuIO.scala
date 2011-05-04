package sudoku

import java.io._
import io.Source
import scala.collection.immutable.VectorBuilder

object SudokuIO {

  def readFile(file: File): Vector[Int] = {
    val b = new VectorBuilder[Int]()
    b.sizeHint(9 * 9)
    Source.fromFile(file).getLines().foreach(line => b ++= line.split(',').map(s => Integer.parseInt(s.trim)))
    b.result()
  }

  def writeFile(os: OutputStream, s: Vector[Int]) = {
    val out = new OutputStreamWriter(os)
    if (s.isEmpty) out.write("no solution") else {
      val sol = for (g <- s.grouped(9).toList; str = (g.head.toString /: g.tail)(_ + ',' + _)) yield str
      out.write((sol.head /: sol.tail)(_ + '\n' + _))
    }
    out.close
  }
}
