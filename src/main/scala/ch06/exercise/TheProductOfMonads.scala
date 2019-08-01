package ch06.exercise

import cats.Monad
import cats.implicits._

object TheProductOfMonads {
  def product[M[_]: Monad, A, B](x: M[A], y: M[B]): M[(A, B)] = for {
    a <- x
    b <- y
  } yield(a, b)
}
