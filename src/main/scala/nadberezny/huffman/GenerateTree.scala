package nadberezny.huffman

object GenerateTree {
  def apply(): Node = reduceNodes(GetLeafs())

  @scala.annotation.tailrec
  private def reduceNodes(nodes: List[Node]): Node = {
    nodes match {
      case node :: Nil =>
        node

      case node1 :: node2 :: tail =>
        val sumNode = Node(
          label = None,
          frequency = node1.frequency + node2.frequency,
          nodes = Some(node1, node2)
        )

        reduceNodes(
          addToNodes(sumNode, tail)
        )
    }
  }

  private def addToNodes(node: Node, nodes: List[Node]): List[Node] = {
    @scala.annotation.tailrec
    def addToNodes(nodes: List[Node], checked: List[Node]): List[Node] = {
      nodes match {
        case Nil =>
          checked:+ node

        case head :: tail if node.frequency <= head.frequency =>
          checked ++ (node :: head :: tail)

        case head :: tail =>
          addToNodes(tail, checked:+ head)
      }
    }

    addToNodes(nodes, List.empty)
  }
}
