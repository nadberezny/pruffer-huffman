package nadberezny.huffman

object App extends App {
  lazy val call = {
    val chars: List[Char] = GetChars("sciezka")
    val leafs: List[Node] = GetLeafs(chars)
    val root: Node = GetRoot(leafs)

    GetRoot(GetLeafs(GetChars("dfdf")))


    (
      getChars andThen getLeafs andThen getRoot
    )("./input/huffman.txt")
  }

  val getChars = GetChars(_)
  val getLeafs = GetLeafs(_)
  val getRoot = GetRoot(_)
}
