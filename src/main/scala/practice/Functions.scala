package practice

import scala.annotation.tailrec


/**
 * Created by Tanmoy
 */
object Functions extends  App {
  def myfunc(item:String) : String = item.toUpperCase

  def parameterlessfunction() :Int = 1000
  println(parameterlessfunction)

  /**
   * Recursive Function
   * @param str
   * @param i
   * @return
   */
  def recursiveFunction(str:String,i:Int): String ={
    if(i ==1 ) str
    else str+" "+recursiveFunction(str,i-1)
  }
  println(recursiveFunction("Tanmoy",4))

  def  unitAsReturnType(str:String):Unit = println(str)
  println(unitAsReturnType("Tanmoy"))

  /**
   * Auxiliary Function (A function inside a function)
   * @param str
   * @return
   */
  def firstFunction(str:String):String ={
    def valFunction():String = "Mukherjee"
    def secondFunction(str1:String ,str2:String):String = str1+" "+str2
    secondFunction(str,valFunction)
  }
  println(firstFunction("Tanmoy"))

  /**
   * Factorial Function
   * @param num
   * @return
   */
  def factorial(num:Int):Int ={
    if(num == 1) num
    else num * factorial(num-1)
  }
  println("Factorial value is :: "+factorial(4))

  /**
   * Tail Recursion Example
   * @param input
   * @param i
   * @param accumulatedValue
   * @return
   */
  @tailrec
  def tailRecursion(input:String , i:Int , accumulatedValue:String):String={
    if(i<0) accumulatedValue
    else tailRecursion(input,i-1, input+" "+accumulatedValue)
  }
  println("Tail Recursion value :: "+tailRecursion("Tanmoy",5,""))

    /*
  def fibonacci(i:Int):Int= {
   if(i<=1) {
     print(i)
     i
   }
   else {
     var v =fibonacci(i-1)+fibonacci(i-2)
     print(v)
     v
   }
  }
  fibonacci(4)
  //println("Printing Fibonacci Series :: "+fibonacci(4))
  */
}
