package nadberezny

import java.io.{File, PrintWriter}

object WritePruffer {
  def apply(filePath: String, code: Seq[Int]): Unit = {
    val writer = new PrintWriter(new File(filePath))

    writer.write("1\n")
    writer.append(code.map(_.toString).reduce(_ + " " + _) + "\n")

    writer.close
  }
}
