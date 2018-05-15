package nadberezny

package object huffman {
  case class Node(
                  label: Option[Char] = None,
                  frequency: Int,
                  nodes: Option[(Node, Node)]
                 )
}
