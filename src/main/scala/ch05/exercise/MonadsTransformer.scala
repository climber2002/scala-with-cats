package ch05.exercise

import cats.data.EitherT
import cats.implicits._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object MonadsTransformer {

//  type Response[A] = Future[Either[String, A]]
  type Response[A] = EitherT[Future, String, A]

  val powerLevels = Map(
    "Jazz"      -> 6,
    "Bumblebee" -> 8,
    "Hot Rod"   -> 10
  )

  def getPowerLevel(autobot: String): Response[Int] = EitherT(Future {
    powerLevels.get(autobot) match {
      case Some(level) => Right(level)
      case None => Left(s"Comms error: $autobot unreachable")
    }
  })

  def canSpecialMove(ally1: String, ally2: String): Response[Boolean] = for {
    power1 <- getPowerLevel(ally1)
    power2 <- getPowerLevel(ally2)
  } yield (power1 + power2 > 15)

  def tacticalReport(ally1: String, ally2: String): String = {
    val canSMove: Response[Boolean] = canSpecialMove(ally1, ally2)
    val canMove = Await.result(canSMove.value, 1 second)
    canMove match {
      case Left(error) => error
      case Right(move) => if(move) s"$ally1 and $ally2 are ready to roll out!" else s"$ally1 and $ally2 need a recharge."
    }
  }

}
