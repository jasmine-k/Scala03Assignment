package edu.knoldus.assignment

import org.scalatest.FunSuite

class FirstPartTest extends FunSuite {

  test("testing first part method"){

    assert(new FirstPart().firstPart("src/test/input01","txt") == List(true, true))

  }

}
