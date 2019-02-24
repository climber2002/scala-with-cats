package ch01.exercise

import cats.Show
import cats.Eq
import cats.instances.int._    // for Eq
import cats.instances.string._ // for Eq
import cats.syntax.eq._ 

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
    def format(cat: Cat): String = 
      cat.name ++ " is a " ++ cat.age.toString ++ " year-old " + cat.color ++ " cat."
  }

  implicit val catShow: Show[Cat] = Show.show(cat => s"${cat.name} is a ${cat.age} year-old ${cat.color} cat.")

  implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    cat1.name === cat2.name &&
    cat1.age === cat2.age &&
    cat1.color === cat2.color
  }
}