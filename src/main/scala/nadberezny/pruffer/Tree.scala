package nadberezny.pruffer

object Tree {
  type Edges = Set[Set[Int]]

  val emptyTree =
    new Tree(Map.empty[Int, Set[Int]].withDefaultValue(Set.empty))

  def apply(elems: (Int, Set[Int])*): Tree = new Tree(elems.toMap)

  def apply(edges: Edges): Tree =
    edges.foldLeft(emptyTree)((tree, edge) =>
      (tree merge (edge.head -> Set(edge.last))) merge (edge.last -> Set(edge.head))
    )
}

class Tree(tree: Map[Int, Set[Int]]) {
  val toMap = tree

  lazy val edges: Set[Set[Int]] =
    (
      for {
        elem: (Int, Set[Int]) <- tree
        outgoingVertex: Int <- elem._2
      } yield Set(elem._1, outgoingVertex)
    ).toSet

  lazy val edgesCount: Int  = tree.size - 1

  lazy val minDegreeVertex: Int = tree.toSeq.sortBy(_._1).sortBy(_._2.size).head._1

  lazy val root: (Int, Set[Int]) = tree.filter(_._2.size == 2).head

  def apply(key: Int): Set[Int] = tree(key)

  def +(kv: (Int, Set[Int])): Tree = new Tree(tree + kv)

  def -(edge: Set[Int]): Tree = Tree(edges - edge)

  def merge(kv: (Int, Set[Int])): Tree = {
    val merged = tree.get(kv._1) match {
      case None => kv._2

      case Some(existing) => existing ++ kv._2
    }

    new Tree(tree + (kv._1 -> merged))
  }
}
