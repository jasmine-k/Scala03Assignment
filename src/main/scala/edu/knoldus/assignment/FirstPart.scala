package edu.knoldus.assignment

import java.io.File

class FirstPart() extends ReadWrite{

  val OUTPUT_DIR = "src/test/output01"

  def firstPart(inputDirectory: String, extension: String):List[Boolean] ={

    val listOfFiles = getListOfFiles(inputDirectory)
    val res = List[Boolean]()

    def editFile(listOfFiles: List[File],res:List[Boolean]):List[Boolean]={

      if(!(listOfFiles.isEmpty)){

        val fileName = listOfFiles.head.toString
        if ((extension != "all" && fileName.endsWith(extension)) || (extension == "all")) {
          val readData: String = read(listOfFiles.head)
          val writeData = readData.toUpperCase
          val result = write(writeData, s"$OUTPUT_DIR",listOfFiles.head )
          editFile(listOfFiles.tail,result::res)
        }
        else {
          editFile(listOfFiles.tail,res)
        }

      }
      else {
        res
      }
    }
    editFile(listOfFiles,res)

  }
}
