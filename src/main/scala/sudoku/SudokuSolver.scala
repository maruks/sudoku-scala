object SudokuSolver {

  val numbers = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)

  def solve(p: Vector[Int]): Vector[Int] = {
    val set = smallestChangeSet(p)
    set match {
      case None => Vector.empty[Int]
      case Some(x) => {
        val sol = for (i <- x._2.view) yield solve(p.updated(x._1, i))
        val res = sol.find(s => !s.isEmpty)
        res.getOrElse(Vector.empty[Int])
      }
    }
  }

  def smallestChangeSet(p: Vector[Int]): Option[(Int, Set[Int])] = {
    val sets = for (i <- 0 to p.size - 1; if (p(i) == 0))
      yield (i, numbers -- (selectRow(p, i) ++ selectColumn(p, i) ++ selectSquare(p, i)))

    if (sets.isEmpty) None else Some(sets.reduceLeft((a, b) => if (a._2.size < b._2.size) a else b))
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
