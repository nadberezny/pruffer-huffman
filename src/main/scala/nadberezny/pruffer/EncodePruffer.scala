package nadberezny.pruffer

object EncodePruffer extends App {

  def encode(tree: Tree): Seq[Int] = {
    def encode(tree: Tree, seq: Seq[Int]): Seq[Int] = {
      tree.edgesCount match {
        case 1 => seq
        case _ =>
          val vertex = tree.minDegreeVertex
          tree(vertex).toList.sorted match {
            case label :: Nil =>
              encode(tree - vertex, seq:+ label)
            case minLabel :: otherLabels =>
              encode(tree + (vertex -> otherLabels.toSet), seq:+ minLabel)
          }
      }
    }

    encode(tree, List.empty)
  }

  // example
  val tree = Tree.apply(
    3 -> Set(1),
    1 -> Set(3, 5, 2),
    5 -> Set(1),
    2 -> Set(1, 4),
    4 -> Set(2)
  )

  println(encode(tree))
}