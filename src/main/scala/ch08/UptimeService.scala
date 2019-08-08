package ch08

import scala.concurrent.Future
import cats.instances.future._
import cats.instances.list._
import cats.syntax.traverse._
import scala.concurrent.ExecutionContext.Implicits.global

class UptimeService(client: UptimeClient) {
  def getTotalUptime(hostnames: List[String]): Future[Int] =
    hostnames.traverse(client.getUptime).map(_.sum)
}
