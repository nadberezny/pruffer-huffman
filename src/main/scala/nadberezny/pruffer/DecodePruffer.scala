package nadberezny.pruffer

import scala.collection.immutable.TreeSet

object DecodePruffer {
  type Edge = Set[Int]

  def apply(codes: Seq[Int]) = {

    @scala.annotation.tailrec
    def decode(codes: List[Int], candidates: TreeSet[Int], edges: Set[Edge]): Set[Edge] = {
      codes match {
        case Nil =>
          val p1 = candidates.head
          val p2 = candidates.last
          val edge: Edge = Set(p1, p2)
          edges + edge

        case code :: codesLeft =>
          val candidate = (candidates -- codes).head
          val edge = Set(code, candidate)
          decode(codesLeft, candidates - candidate, edges + edge)
      }
    }

    decode(codes.toList, TreeSet((1 to codes.size + 2).toList:_*) , Set.empty)
  }
}
