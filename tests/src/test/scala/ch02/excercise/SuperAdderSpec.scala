package ch02.excercise

import ch02.exercise.SuperAdder
import org.scalatest.{FlatSpec, Matchers}

class SuperAdderSpec extends FlatSpec with Matchers {
  it should "add items" in {
    SuperAdder.add(List(1, 2, 3)) should be (6)
  }

  it should "add option items" in {
    SuperAdder.addOption(List(Some(1), None, Some(2), None, Some(3))) should be (Some(6))
  }
}
