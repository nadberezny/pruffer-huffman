package nadberezny.huffman


object GetLabeledTree {
  type Tree = Map[Int, Set[Int]]
  type Edge = (Int, Int)

  def apply(root: Node) = {
    new GetLabeledTree(root).traverse
  }
}

private class GetLabeledTree(root: Node) {
  private var counter = 1

  type Edge = (Int, Int)


  def traverse = {
    def traverse(nodes: List[Node], edges: List[Node]): List[Node] = {
      nodes match {
        case Nil => edges

        case Node(_, _, None) :: nodesLeft => traverse(nodesLeft, edges)

        case node :: nodesLeft =>
          val outgoingNodes = node.nodes.get
          val newNodes = outgoingNodes._1 :: outgoingNodes._2 :: nodesLeft
          val newEdges = outgoingNodes._1 :: outgoingNodes._2 :: edges

          traverse(newNodes, newEdges)
      }

    }

    val n = root.nodes.get
    traverse(List(n._1, n._2), List(root, n._1, n._2))
  }
}
