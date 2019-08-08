package ch08

import scala.concurrent.Future

class RealUptimeClient(hosts: Map[String, Int]) extends UptimeClient[Future] {
  override def getUptime(hostname: String): Future[Int] = Future.successful(hosts.getOrElse(hostname, 0))
}
