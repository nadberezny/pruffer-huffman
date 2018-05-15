package nadberezny.huffman

object GetLeafs {
  def apply(): List[Node] = {
    charFrequencies
      .toSeq
      .sortBy(_._2)
      .map(seq =>
        Node(Some(seq._1), seq._2, None)
      )
      .toList
  }

  private lazy val charFrequencies: Map[Char, Int] =
    GetChars()
      .foldLeft(mapWithDefault)((map, char) =>
         map + (char -> (map(char) + 1))
      )

  private lazy val mapWithDefault =
    Map.empty[Char, Int].withDefaultValue(0)
}
