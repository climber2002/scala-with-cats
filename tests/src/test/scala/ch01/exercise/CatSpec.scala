package ch01.exercise

import org.scalatest._

class CatSpec extends FlatSpec with Matchers {
  "Printable" should "format cat" in {
    val cat = Cat("Maomao", 2, "gold")
    Printable.format(cat) should be ("Maomao is a 2 year-old gold cat.")
  }
}