package nadberezny.huffman

import scala.io.Source

object GetChars {
  def apply(filePath: String): List[Char] = {
    val source = Source.fromFile(filePath)

    val chars: List[Char] = (for {
      line <- source.getLines
      char <- line
    } yield char).toList

    source.close

    chars
  }

}
