package ch08


trait UptimeClient[F[_]] {
  def getUptime(hostname: String): F[Int]
}
