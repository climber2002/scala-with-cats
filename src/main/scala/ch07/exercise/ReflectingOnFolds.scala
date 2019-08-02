package ch07.exercise

object ReflectingOnFolds {
  def foldLeftUsingEmptyList =
    List(1, 2, 3).foldLeft(List.empty[Int])((list, i) => i :: list)

  def foldRightUsingEmptyList =
    List(1, 2, 3).foldRight(List.empty[Int])(_ :: _)
}
