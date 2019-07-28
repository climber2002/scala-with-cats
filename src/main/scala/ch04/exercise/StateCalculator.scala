package ch04.exercise

import cats.data.State

object StateCalculator {
  type CalcState[A] = State[List[Int], A]

  def evalOne(sym: String): CalcState[Int] = State { state =>
    (sym, state) match {
      case ("+", op1 :: op2 :: tail) => ((op1 + op2) :: tail, op1 + op2)
      case ("-", op1 :: op2 :: tail) => ((op1 - op2) :: tail, op1 - op2)
      case ("*", op1 :: op2 :: tail) => ((op1 * op2) :: tail, op1 * op2)
      case ("/", op1 :: op2 :: tail) => ((op1 / op2) :: tail, op1 / op2)
      case (num, state) => (num.toInt :: state, num.toInt)
    }
  }

  def evalAll(input: List[String]): CalcState[Int] = input.foldLeft(State.inspect((_: List[Int]) => 0)) { (a, b) =>
    a.flatMap(_ => evalOne(b))
  }
  
}
