package ch08

import scala.concurrent.Future

trait UptimeClient {
  def getUptime(hostname: String): Future[Int]
}
