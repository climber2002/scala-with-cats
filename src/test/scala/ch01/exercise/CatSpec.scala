package ch01.exercise

import org.scalatest._

import cats.Show
import cats.Eq

class CatSpec extends FlatSpec with Matchers {
  "Printable" should "format cat" in {
    val cat = Cat("Maomao", 2, "gold")
    Printable.format(cat) should be ("Maomao is a 2 year-old gold cat.")
  }

  it should "show cat" in {
    val cat = Cat("Maomao", 2, "gold")
    Show.apply[Cat].show(cat) should be ("Maomao is a 2 year-old gold cat.")
  }

  it should "compare cats" in {
    val cat1 = Cat("Maomao", 2, "gold")
    val cat2 = Cat("Maomao", 2, "gold")
    
    (Eq[Cat].eqv(cat1, cat2)) should be (true)
  }
}