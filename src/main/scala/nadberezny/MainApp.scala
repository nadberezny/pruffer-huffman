package nadberezny

import nadberezny.huffman.{GetChars, GetLabeledEdges, GetLeafs, GetRoot}
import nadberezny.pruffer.{DecodePruffer, EncodePruffer, Tree}

object appFunctions {
  val getChars = GetChars(_)
  val getLeafs = GetLeafs(_)
  val getHuffmanTree = GetRoot(_)
  val getLabeledEdges = GetLabeledEdges(_)
  val getTree = (edges: Set[Set[Int]]) => Tree(edges)
  val encodePruffer = EncodePruffer(_)
  val decodePruffer = DecodePruffer(_)
}

object MainApp extends App {
  import appFunctions._

  lazy val chars = getChars(args.head)

  lazy val prufferCode = (
    getLeafs
    andThen getHuffmanTree
    andThen getLabeledEdges
    andThen getTree
    andThen encodePruffer
  )(chars)

  lazy val decodedTree = Tree(decodePruffer(prufferCode))

  args.headOption match {
    case None =>
      println("Please provide path to the text file.")

    case Some(filePath) =>
      WritePruffer(filePath , prufferCode)
      WriteGraph("./graph.dot", decodedTree)
      println("Great success! File graph.dot created.")
  }
}
