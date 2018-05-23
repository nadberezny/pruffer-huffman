package nadberezny

import java.io.{File, PrintWriter}

object WritePruffer {
  def apply(code: Seq[Int], rootLabel: Int): Unit = {
    val writer = new PrintWriter(new File("pruffer.txt"))

    writer.write(s"$rootLabel\n")
    writer.append(code.map(_.toString).reduce(_ + " " + _) + "\n")

    writer.close
  }
}
