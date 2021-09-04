package oop

object MyObject {

  val func1:((Int,Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  def main(args: Array[String]): Unit = {
    val data = new MyTrait[Int,Int] {
      override def apply(number: Int): Int = number * 2
    }
    println(data(2))
    println(func1(4,4))
  }

}
