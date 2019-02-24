package ch01.exercise

import org.scalatest._
import PrintableSyntax._

class PrintableSyntaxSpec extends FlatSpec with Matchers {
  it should "format a cat" in {
    val cat = Cat("Maomao", 2, "gold")
    cat.format should be ("Maomao is a 2 year-old gold cat.")
  }
}