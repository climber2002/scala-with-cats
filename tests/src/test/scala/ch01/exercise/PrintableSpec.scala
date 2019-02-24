package ch01.exercise

import org.scalatest._
import PrintableInstances._

class PrintableSpec extends FlatSpec with Matchers {
  "Printable" should "format a string" in {
    Printable.format("abc") should be ("abc")
  }
}