package nadberezny.huffman

import scala.io.Source

object GetChars {
  def apply(): List[Char] = {
    val source = Source.fromFile("./input/huffman.txt")

    val chars: List[Char] = (for {
      line <- source.getLines
      char <- line
    } yield char).toList

    source.close

    chars
  }

}
