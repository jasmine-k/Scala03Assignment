
package edu.knoldus.assignment

import java.io.File

class SecondPart() extends ReadWrite{

  val OUTPUT_DIR = "src/test/output02"

  def secondPart(inputFilePath: String): Boolean = {

    val file = new File(inputFilePath)
    val readData: String = read(file).toLowerCase
    val regex = """[A-Za-z]+""".r
    val tempStr2 = for(
      tempStr1 <- regex.findAllIn(readData)
    ) yield tempStr1
    val tempStr3 = tempStr2.toList
    val writeData = tempStr3.groupBy(identity).mapValues(_.size).mkString("\n")
    write(writeData, s"$OUTPUT_DIR" ,file )

  }
}
