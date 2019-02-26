package ch04.exercise

object Id {

  type Id[A] = A

  implicit val idMonad = new Monad[Id] {

    override def pure[A](a: A): Id[A] = a

    override def map[A, B](value: Id[A])(func: (A) => B): Id[B] = func(value)

    override def flatMap[A, B](value: Id[A])(func: (A) => Id[B]): Id[B] = func(value)
  }
}


