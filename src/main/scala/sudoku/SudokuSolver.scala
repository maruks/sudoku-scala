object SudokuSolver {

  val numbers = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)

  def solve(p: Vector[Int]): Vector[Int] = {
    val set = findChangeSet(p)
    if (set._2.isEmpty) {
      Vector.empty[Int]
    } else {
      val iter = set._2.iterator
      var result = p
      do {
        result = solve(p.updated(set._1, iter.next))
      } while (result.isEmpty && iter.hasNext)
      result
    }
  }

  def findChangeSet(p: Vector[Int]): (Int, Set[Int]) = {
    val sets = for (i <- 0 to 80; if (p(i) == 0))
      yield (i, numbers -- (selectRow(p, i) ++ selectColumn(p, i) ++ selectSquare(p, i)))
    sets.reduceLeft((a, b) => if (a._2.size < b._2.size) a else b)
  }

  def selectRow(p: Vector[Int], i: Int): Set[Int] = {
    numbers
  }

  def selectColumn(p: Vector[Int], i: Int): Set[Int] = {
    numbers
  }

  def selectSquare(p: Vector[Int], i: Int): Set[Int] = {
    numbers
  }
}
