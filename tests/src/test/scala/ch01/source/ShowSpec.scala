package ch01.exercise

import org.scalatest._

import cats.Show
import cats.instances.string._


class ShowSpec extends FlatSpec with Matchers {
  "Show" should "format a string" in {
    Show.apply[String].show("abc") should be ("abc")
  }
}