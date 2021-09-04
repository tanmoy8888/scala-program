package functions

object HigherOrderFunctions {
  def main(args: Array[String]): Unit = {
    printAllcombinationOfTwoLists
    printAllcombinationOfThreeLists
  }
  /**
   * Print all the combinations of Two Lists(One is Integer and Another one is Char) elements
   */
  def printAllcombinationOfTwoLists(): Unit ={
    val list1 = List(1,2,3,4)
    val list2 = List('a','b','c','d')
    val combination = list1.flatMap(e => list2.map(c => ""+c+e))
    println(combination)
  }

  /**
   * Print all the combinations of Three Lists(One is Integer and Another one is Char) elements
   */
  def printAllcombinationOfThreeLists(): Unit ={
    val list1 = List(1,2,3,4)
    val list2 = List('a','b','c','d')
    val list3 = List('%','$','#','&')
    val combination = list1.flatMap(e => list2.flatMap(c => list3.map(s => ""+c+e+s)))
    println(combination)
  }
}
