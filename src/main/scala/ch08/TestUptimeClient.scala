package ch08
import scala.concurrent.Future

class TestUptimeClient(hosts: Map[String, Int]) extends UptimeClient {
  override def getUptime(hostname: String): Future[Int] =
    Future.successful(hosts.getOrElse(hostname, 0))
}

object TestUptimeClient {
  def testTotalUptime() = {
    val hosts = Map("host1" -> 10, "host2" -> 6)
    val client = new TestUptimeClient(hosts)
    val service = new UptimeService(client)
    val actual = service.getTotalUptime(hosts.keys.toList)

    val expected = hosts.values.sum
    assert(actual == expected)
  }
}
