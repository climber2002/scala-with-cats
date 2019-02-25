package ch02.exercise

import cats.Monoid
import cats.instances.int._

object SuperAdder {
  def add(items: List[Int]): Int = {
    Monoid[Int].combineAll(items)
  }
}
