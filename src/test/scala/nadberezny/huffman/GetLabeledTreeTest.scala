package nadberezny.huffman

import org.scalatest.{FunSuite, Ignore}

@Ignore
class GetLabeledTreeTest extends FunSuite {
  test(".apply") {
    val root = Node(
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
  }

}
