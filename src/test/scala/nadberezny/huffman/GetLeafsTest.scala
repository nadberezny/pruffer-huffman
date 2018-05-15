package nadberezny.huffman

import org.scalatest.FunSuite

class GetLeafsTest extends FunSuite {
  test(".apply") {
    val expectedLeafs = Seq(
      Node(Some('a'), 5, None),
      Node(Some('b'), 9, None),
      Node(Some('c'), 12, None),
      Node(Some('d'), 13, None),
      Node(Some('e'), 16, None),
      Node(Some('f'), 45, None)
    )

    assert(GetLeafs() == expectedLeafs)
  }

}
