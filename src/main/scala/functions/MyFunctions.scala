package functions

object MyFunctions extends  App {

  // Anonymous function/Lambda
  val square:Int => Int = (x) => x*x

  // Multiple parameters lambda,
  val addition:(Int,Int) => Int = (x,y) => x+y

  // No Parameter lambda
  val show:() => Int = () => 3

  // *********************** IMPORTANT ***************************************
  // In case of lambda no parameter funtions can not be called with out () ....
  println(show)
  println(show())

  // Syntactic Sugar
  val additionShort : (Int,Int) => Int = _ + _

  // Other ways to write same fucntion
  val superAddition = (x:Int) => (y:Int) => x+y
  println("Super Addition :: "+superAddition(2)(3))
}
