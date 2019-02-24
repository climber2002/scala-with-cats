package ch01.exercise

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
    def format(cat: Cat): String = 
      cat.name ++ " is a " ++ cat.age.toString ++ " year-old " + cat.color ++ " cat."
  }
}