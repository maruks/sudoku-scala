package sudoku

object SudokuSolver {

  def solve(p: Vector[Int]): Option[Vector[Int]] = {
    smallestChangeSet(p) match {
      case None => Some(p)
      case Some(set) if set._2.isEmpty => None
      case Some(set) => {
        val sol = for (i <- set._2.toSeq.sorted.view) yield solve(p.updated(set._1, i))
        sol.find(_.isDefined).getOrElse(None)
      }
    }
  }

  def smallestChangeSet(p: Vector[Int]): Option[(Int, Set[Int])] = {
    val sets = for (i <- 0 to p.size - 1; if (p(i) == 0))
      yield (i, (1 to 9).toSet -- (selectRow(p, i) ++ selectColumn(p, i) ++ selectSquare(p, i)))
    if (sets.isEmpty) None else Some(sets.reduceRight((a, b) => if (a._2.size < b._2.size) a else b))
  }

  def selectRow(p: Vector[Int], i: Int) = {
    for (i <- (i - i % 9 to i - i % 9 + 8).toSet[Int]) yield p(i)
  }

  def selectColumn(p: Vector[Int], i: Int) = {
    for (i <- (i % 9 to i % 9 + 72 by 9).toSet[Int]) yield p(i)
  }

  def selectSquare(p: Vector[Int], i: Int) = {
    val x = i % 9 - (i % 9) % 3
    val y = i / 9 - (i / 9) % 3
    val spos = x + y * 9
    val r = (spos to spos + 2)
    for (i <- (r ++ r.map(_ + 9) ++ r.map(_ + 18)).toSet[Int]) yield p(i)
  }
}
