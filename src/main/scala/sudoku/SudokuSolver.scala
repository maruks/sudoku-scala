package sudoku

object SudokuSolver {

  def solve(p: Vector[Int]): Option[Vector[Int]] = {
    smallestChangeSet(p) match {
      case None => Some(p)
      case Some(set) if set._2.isEmpty => None
      case Some(set) => {
        val sol = set._2.toSeq.sorted.view.map(i => solve(p.updated(set._1, i)))
        sol.find(_.isDefined).getOrElse(None)
      }
    }
  }

  def smallestChangeSet(p: Vector[Int]): Option[(Int, Set[Int])] = {
    val sets = (0 to p.size - 1).filter(p(_) == 0).map( i => (i, possibleValues(p,i)))
    if (sets.isEmpty) None else Some(sets.reduceRight((a, b) => if (a._2.size < b._2.size) a else b))
  }

  def possibleValues(p: Vector[Int], i: Int) = {
    (1 to 9).toSet -- (selectRow(p, i) ++ selectColumn(p, i) ++ selectSquare(p, i))
  }

  def selectRow(p: Vector[Int], i: Int) = {
    (i - i % 9 to i - i % 9 + 8).map(p(_)).toSet[Int]
  }

  def selectColumn(p: Vector[Int], i: Int) = {
    (i % 9 to i % 9 + 72 by 9).map(p(_)).toSet[Int]
  }

  def selectSquare(p: Vector[Int], i: Int) = {
    val x = i % 9 - (i % 9) % 3
    val y = i / 9 - (i / 9) % 3
    val spos = x + y * 9
    val r = (spos to spos + 2)
    (r ++ r.map(_ + 9) ++ r.map(_ + 18)).map(p(_)).toSet[Int]
  }
}
