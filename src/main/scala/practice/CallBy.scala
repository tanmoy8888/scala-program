package practice

/**
 * Created By Tanmoy
 */

object CallBy extends App {

  def callByValue(time:Long):Unit={
    println("Call By Value :: "+time)
    println("Call By Value :: "+time)
  }
  callByValue(System.nanoTime())

  /**
   * => Operator used to define Call By Name
   * @param time
   */
  def callByName(time: => Long):Unit={
    println("Call By Name :: "+time)
    println("Call By Name :: "+time)
  }
  callByName(System.nanoTime())

}
