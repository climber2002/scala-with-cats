package ch04.exercise

import cats.data.Writer
import cats.instances.vector._
import cats.syntax.applicative._
import cats.syntax.writer._

object WriterShowYourWorking {
  def slowly[A](body: => A) =
    try body finally Thread.sleep(100)

  def factorial(n: Int): Int = {
    val ans = slowly(if(n == 0) 1 else n * factorial(n - 1))
    println(s"fact $n $ans")
    ans
  }

  type Logged[A] = Writer[Vector[String], A]

  def factorialWithWriter(n: Int): Logged[Int] =
    for {
      ans <- if(n == 0) {
        1.pure[Logged]
      } else {
        slowly(factorialWithWriter(n - 1).map(_ * n))
      }
      _   <- Vector(s"fact $n $ans").tell
    } yield ans

}
