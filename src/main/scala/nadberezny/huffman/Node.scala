package nadberezny.huffman

import nadberezny.pruffer.Tree

case class Node(
                 label: Option[Char] = None,
                 frequency: Int,
                 nodes: Option[(Node, Node)]
               ) {

  lazy val isEmpty: Boolean = nodes match {
    case None => true
    case _ => false
  }

  lazy val self: Node = Node(label, frequency, nodes)

  def toTree: Tree = {
    
  }

  def flatten: List[Node] = {
    def flatten(toFlatten: List[Node], nodes: List[Node]): List[Node] = {
      toFlatten match {
        case Nil =>
          nodes

        case Node(_, _, None) :: toFlattenLeft =>
          flatten(toFlattenLeft, nodes)

        case Node(_, _, Some(outgoingNodes)) :: toFlattenLeft =>
          flatten(
            outgoingNodes._1 :: outgoingNodes._2 :: toFlattenLeft,
            outgoingNodes._1 :: outgoingNodes._2 :: nodes
          )
      }
    }

    if (isEmpty) List(self) else {
      flatten(
        List(nodes.get._1, nodes.get._2),
        List(self, nodes.get._1, nodes.get._2)
      )
    }
  }
}


