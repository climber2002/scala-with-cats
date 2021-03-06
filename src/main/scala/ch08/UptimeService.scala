package ch08

import cats.Applicative

import scala.concurrent.Future
import cats.instances.future._
import cats.instances.list._
import cats.syntax.traverse._
import cats.syntax.functor._

import scala.concurrent.ExecutionContext.Implicits.global

class UptimeService[F[_]](client: UptimeClient[F])(implicit applicative: Applicative[F]) {
  def getTotalUptime(hostnames: List[String]): F[Int] =
    (hostnames.traverse(client.getUptime)).map(_.sum)
}
