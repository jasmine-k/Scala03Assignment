
package edu.knoldus.assignment

import java.io.File;
import java.net.URL

class ThirdPart() extends ReadWrite{

  val OUTPUT_DIR = "src/test/output03"

  def getResults(inputFilePath: String): String = {

    val urls = read(new File(inputFilePath))
    val result = urls.split("\n").map(x=>splitURL(x)).mkString("\n")
    result

  }

  def splitURL(urlString: String): String = {

    val url:URL  =  new URL(urlString.trim())
    url match {
      case URLParser(protocol, host, domain, params) => s"Protocol -> $protocol, Host -> $host, Domain -> $domain, " +
        s"Query params -> $params"
    }
  }

  def thirdPart(inputFilePath: String): Boolean = {

    val file = new File(inputFilePath)
    val writeData = getResults(inputFilePath)
    write(writeData, s"$OUTPUT_DIR" ,file )

  }

}

object URLParser {

  def unapply(url:java.net.URL): Option[(String,String,String,Map[String,String])] ={

    val protocol = url.getProtocol
    val hostName = url.getHost
    val regex = "[a-z]+\\.([a-z]+)\\.(.*)".r
    val regex(host,domain) = hostName
    val query = url.getQuery

    if(query == null) {
      Some(protocol, host,domain,null)

    }
    else{

      def splitKeyValue(query1:String):(String,String)={

        val temp = query1.split("=")
        (temp(0),(temp(1)))
      }

        val map:Map[String,String] = {
        val parts = query.split("&")
        parts.map(x=> splitKeyValue(x)).toMap
      }
      Some(protocol, host, domain, map)
    }
  }
}
