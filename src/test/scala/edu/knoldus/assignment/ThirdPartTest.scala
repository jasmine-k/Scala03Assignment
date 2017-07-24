package edu.knoldus.assignment

import org.scalatest.FunSuite

class ThirdPartTest extends FunSuite {

  test("testing parse URL method"){

    assert(new ThirdPart().thirdPart("src/test/input03/a1.txt") == true)
  }

  test("testing parse URL method with correct input"){
    assert(new ThirdPart().getResults("src/test/input03/a2.txt") == "Protocol -> https, Host -> google, Domain -> co.in, Query params -> Map(gfe_rd -> cr)")
  }

}
