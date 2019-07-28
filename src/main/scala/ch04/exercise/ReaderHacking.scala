package ch04.exercise

import cats.data.Reader
import cats.syntax.applicative._

object ReaderHacking {

  case class Db(usernames: Map[Int, String], passwords: Map[String, String])

  type DbReader[A] = Reader[Db, A]

  def findUsername(userId: Int): DbReader[Option[String]] = Reader { db =>
    db.usernames.get(userId)
  }

  def checkPassword(username: String, password: String): DbReader[Boolean] = Reader { db =>
    db.passwords.get(username).map(pass => password == pass).getOrElse(false)
  }

  def checkLogin(userId: Int, password: String): DbReader[Boolean] = for {
    maybeUsername <- findUsername(userId)
    passwordOk <- maybeUsername.map(username => checkPassword(username, password)).getOrElse(false.pure[DbReader])
  } yield passwordOk
}
