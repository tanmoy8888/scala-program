package pattern

import scala.util.Random

/**
 * Made by Tanmoy Mukherjee
 */

object PatterMatching {
  def main(args: Array[String]): Unit = {
    val random = new Random()
    val randomValue = random.nextInt(4)
    println("Random Value is :: "+randomValue)
    println("Patter Matched Value is :: "+getPatters(randomValue))

  }

  def getPatters(x:Int):String={
    x match {
      case 1 => "This is one"
      case 2 => "This is two"
      case 3 => "This is three"
      case 4 => "This is four"
      case _ => "This is default case"
    }
  }
  case class Person(name:String,age:Int)
  val bob = Person("Bob",20)

  def checkPerson(p:Person):String={
    p match {
      case Person(name, age) if(age <21) => s"Person name is $name , age is $age"
      case _ => "I don't know this person"
    }
  }
  println("case class pattern matching :: "+checkPerson(bob))

  // Checking List content with pattern matching
  val list:List[Int] = List(1,2,3,4)
  val listCheck = list match {
    case List(1,2,4,3) => println("This is matched")
    case 1::List(2,3,4) => println("This matched with the input")
    case _ => println("No match found")
  }



}
