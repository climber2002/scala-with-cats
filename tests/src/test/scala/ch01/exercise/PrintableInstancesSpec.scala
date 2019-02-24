package ch01.exercise

import org.scalatest._
import PrintableInstances._

class PrintableInstancesSpec extends FlatSpec with Matchers {
  "stringPrintable" should "format a string" in {
    stringPrintable.format("abc") should be ("abc")
  }
}