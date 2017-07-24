package edu.knoldus.assignment

import scala.io.Source
import java.io._
import java.io.File

abstract class ReadWrite {

  def read(fileName: File): String={

    val readFile = Source.fromFile(fileName)
    readFile.getLines.mkString("\n")

  }

  def write (writeData: String, dirPath: String, file : File):Boolean ={

    new File(dirPath).mkdir()
    try {
      new PrintWriter(dirPath + "/" + file.getName) {
        write(writeData)
        close
      }
      true
    }
    catch {
      case e : Exception => false
    }
  }

  def getListOfFiles (directory: String): List[File] ={

    val file:File = new File(directory)
    if (file.exists && file.isDirectory) {

      file.listFiles.filter(_.isFile).toList
    }
    else {
      throw new Exception(" No file or directory exist")
    }
  }

}
