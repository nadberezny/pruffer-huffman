package nadberezny.huffman

object GetLeafs {
  def apply(chars: List[Char]): List[Node] = {
    charFrequencies(chars)
      .toSeq
      .sortBy(_._2)
      .map(seq =>
        Node(Some(seq._1), seq._2, None)
      )
      .toList
  }

  private def charFrequencies(chars: List[Char]): Map[Char, Int] =
    chars
      .foldLeft(mapWithDefault)((map, char) =>
         map + (char -> (map(char) + 1))
      )

  private lazy val mapWithDefault =
    Map.empty[Char, Int].withDefaultValue(0)
}
