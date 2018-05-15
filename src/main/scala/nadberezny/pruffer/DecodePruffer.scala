package nadberezny.pruffer

import scala.collection.immutable.TreeSet

object DecodePruffer extends App {
  type Edge = (Int, Int)

  def decode(codes: List[Int]) = {

    @scala.annotation.tailrec
    def decode(codes: List[Int], possible: TreeSet[Int], edges: Set[Edge]): Set[Edge] = {
      codes match {
        case Nil =>
          val p1 = possible.head
          val p2 = possible.last
          val edge: Edge = (p1, p2)
          edges + edge

        case code :: codesLeft =>
          val p = (possible -- codes).head
          val edge = (code, p)
          decode(codesLeft, possible - p, edges + edge)
      }
    }

    decode(codes, TreeSet((1 to codes.size + 2).toList:_*) , Set.empty)
  }

  val codes = List(1, 2, 1)
  println(
    decode(codes)
  )
}
