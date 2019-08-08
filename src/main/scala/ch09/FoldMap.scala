package ch09

import cats.kernel.Monoid
import cats.syntax._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FoldMap {
  def foldMap[A, B](as: Vector[A])(f: A => B)(implicit mb: Monoid[B]): B =
    as.map(f).foldLeft(mb.empty)((result, b) => mb.combine(result, b))

  def parallelFoldMap[A, B : Monoid](values: Vector[A])(func: A => B)(implicit mb: Monoid[B]): Future[B] = {
    val cpuCount = Runtime.getRuntime.availableProcessors
    Future.sequence( values.grouped(cpuCount).toList.map(as => Future { foldMap(as)(func)(mb) })).map { bs =>
      bs.foldLeft(mb.empty)((result, b) => mb.combine(result, b))
    }
  }
}
