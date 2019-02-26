package ch02.exercise

import cats.Monoid
import cats.instances.int._
import cats.instances.option._

case class Order(totalCost: Double, quantity: Double)

object Order {
  implicit val orderMonoid = new Monoid[Order] {
    override def empty: Order = Order(0, 0)

    override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
  }
}

object SuperAdder {
  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)((item1, item2) => monoid.combine(item1, item2))

  def add(items: List[Int]): Int = {
    add(items)
  }

  def addOption(items: List[Option[Int]]): Option[Int] = {
    add(items)
  }

  def addOrders(items: List[Order]): Order = add(items)
}
