package ch02.excercise

import ch02.exercise.SuperAdder
import org.scalatest.{FlatSpec, Matchers}

class SuperAdderSpec extends FlatSpec with Matchers {
  it should "add items" in {
    SuperAdder.add(List(1, 2, 3)) should be (6)
  }
}
