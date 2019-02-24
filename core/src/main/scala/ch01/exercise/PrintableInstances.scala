package ch01.exercise

object PrintableInstances {
  implicit val stringPrintable: Printable[String] = new Printable[String] {
    def format(str: String): String = str
  }

  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    def format(i: Int): String = i.toString
  }
}