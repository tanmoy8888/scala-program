package functions



object FunctionsPractice {
  def doubleValues(x:Int):Int = x*2

  def findSumOfCertainRange(i:Int): Unit ={
    (1 to i).map(_*2).foreach(println)
  }

  // Scala withFilter Example

  def checkWithFilterExample(list:List[String]):List[String] ={
    list.withFilter(_.contains("tanmoy")).map(_.toUpperCase)
  }

  def main(args: Array[String]): Unit = {

    val result = (1 to 10).map(doubleValues)
    println("Result is :: "+result)
    findSumOfCertainRange(10)


    val list = List("abc","atanmoy","btanmoy","xyz")
    checkWithFilterExample(list).foreach(println)
  }



}
