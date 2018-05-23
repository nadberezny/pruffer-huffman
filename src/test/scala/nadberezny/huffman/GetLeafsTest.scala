package nadberezny.huffman

import org.scalatest.FunSuite

class GetLeafsTest extends FunSuite {
  test(".apply") {
    val chars = List('c', 'a', 'b', 'a', 'a', 'c')

    val expectedLeafs = List(
      Node(Some('b'), 1, None),
      Node(Some('c'), 2, None),
      Node(Some('a'), 4, None)
    )

    assert(GetLeafs(chars) == expectedLeafs)
  }

}
