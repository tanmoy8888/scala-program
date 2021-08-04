package practice

object SmartStringOperations{

  //Scala Specific String Operations

  def convertStringtoInteger(str:String):Int = str.toInt
  def reverseAString(str:String):String=str.reverse
  def takefirstCharDynamically(str:String,i:Int):String = str.take(i)
  def stringInterpolation(str1:String,str2:String):String = s"Hi My name is $str1 and my title is $str2"
  def stringInterpolationExpression(str1:String,str2:String) = s"Concating two String into one single String ${str1+str2}"



  def main(args: Array[String]): Unit = {
    println("Converting String to Integer :: "+convertStringtoInteger("4"))
    println("Reversing a String :: "+reverseAString("Tanmoy"))
    println("Taking First 2 Char of a String :: "+takefirstCharDynamically("Tanmoy",2))
    println("Taking First 4 Char of a String :: "+takefirstCharDynamically("Tanmoy",4))
    println("String Interpolation example :: "+stringInterpolation("Tanmoy","Mukherjee"))
    println(stringInterpolationExpression("Hello","World"))
  }
}
