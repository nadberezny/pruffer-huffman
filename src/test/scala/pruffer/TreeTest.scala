package pruffer

import nadberezny.pruffer.Tree
import org.scalatest.FunSuite

class TreeTest extends FunSuite {
  lazy val edges = Set(
    Set(1, 3), Set(1, 2), Set(5, 1), Set(2, 4)
  )

  lazy val tree = Tree(edges)

  test("apply from edges") {
    val expectedMap = Map(
      1 -> Set(2, 3, 5),
      2 -> Set(1, 4),
      3 -> Set(1),
      4 -> Set(2),
      5 -> Set(1)
    )

    assert(tree.toMap == expectedMap)
  }

  test("#edgesCount") {
    assert(tree.edgesCount == 4)
  }

  test("#minDegreeVertex") {
    assert(tree.minDegreeVertex == 3)
  }
}
