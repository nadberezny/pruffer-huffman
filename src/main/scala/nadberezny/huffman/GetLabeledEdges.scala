package nadberezny.huffman

object GetLabeledEdges {
  def apply(node: Node): Set[Set[Int]] = {
    new GetLabeledEdges(node).convert
  }
}

private class GetLabeledEdges(node: Node) {
  private var counter = 1

  private lazy val nodes = node.flatten

  private var labelMap = Map.empty[Node, Int]

  private var edges: Set[Set[Int]] = Set.empty

  def convert = {
    for (node <- nodes if node.nodes.isDefined) {
      val label1 = label(node)
      val label2 = label(node.nodes.head._1)
      val label3 = label(node.nodes.head._2)

      edges = edges + Set(label1, label2)
      edges = edges + Set(label1, label3)
    }
    edges
  }

  def label(node: Node): Int = {
    labelMap.get(node) match {
      case Some(label) => label
      case _ =>
        val label = counter
        counter = counter + 1
        labelMap = labelMap + (node -> label)
        label
    }
  }
}
