package nadberezny

import java.io.{File, PrintWriter}
import nadberezny.pruffer.Tree

object WriteGraph {
  def apply(filePath: String, tree: Tree): Unit = {
    val writer = new PrintWriter(new File(filePath))

    writer.write("graph {\n")
    for(edge <- tree.edges) {
      writer.append(s"${edge.head} -- ${edge.last};\n")
    }
    writer.append("}\n")

    writer.close
  }

}
