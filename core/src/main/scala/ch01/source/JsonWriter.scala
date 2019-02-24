package ch01.source

trait JsonWriter[A] {
  def write(value: A): Json
}