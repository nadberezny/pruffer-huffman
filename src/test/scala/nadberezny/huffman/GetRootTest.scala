package nadberezny.huffman

import org.scalatest.{FunSuite, Ignore}

@Ignore
class GetRootTest extends FunSuite {
  test(".apply") {
    val leafs = List(
      Node(Some('b'), 5, None),
      Node(Some('b'), 9, None),
      Node(Some('c'), 12, None),
      Node(Some('d'), 13, None),
      Node(Some('e'), 16, None),
      Node(Some('f'), 45, None)
    )

    val expectedTree = Node(
      None,
      100,
      Some(
        Node(Some('f'), 45, None),
        Node(
          None,
          55,
          Some(
            (
              Node(
                None,
                25,
                Some(
                  (
                    Node(Some('c'), 12, None),
                    Node(Some('d'), 13, None)
                  )
                )
              ),
              Node(
                None,
                30,
                Some(
                  (
                    Node(
                      None,
                      14,
                      Some(
                        (
                          Node(Some('a'), 5, None),
                          Node(Some('b'), 9, None)
                        )
                      )
                    ),
                    Node(Some('e'), 16, None)
                  )
                )
              )
            )
          )
        )
      )
    )

    assert(GetRoot(leafs) == expectedTree)
  }
}
