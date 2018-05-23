package nadberezny.pruffer

object EncodePruffer {
  def apply(tree: Tree): Seq[Int] = {
    def encode(tree: Tree, seq: Seq[Int]): Seq[Int] = {
      tree.edgesCount match {
        case 1 => seq
        case _ =>
          val vertex = tree.minDegreeVertex
          tree(vertex).toList.sorted match {
            case label :: Nil =>
              encode(tree - Set(vertex, label), seq:+ label)
            case minLabel :: otherLabels =>
              encode(tree + (vertex -> otherLabels.toSet), seq:+ minLabel)
          }
      }
    }

    encode(tree, List.empty)
  }
}