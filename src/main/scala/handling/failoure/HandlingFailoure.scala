package handling.failoure

import scala.util.{Failure, Success, Try}

object HandlingFailoure {
  def main(args: Array[String]): Unit = {
    val successScenario = Success(4)
    val failoureScenario = Failure(new RuntimeException("This is a failure scenario"))

    println(successScenario)
    println(failoureScenario)

    // Catch the failure scenario using Try
    def potentialFailure():String = throw new RuntimeException("This is a potential failure block")
    val catchFailure = Try(potentialFailure)
    println("Try example :: "+catchFailure)
    println(catchFailure.isSuccess)
    println(catchFailure.isFailure)
    //def potentialSuccess():String = throw new RuntimeException("This is a potential success message")
    def potentialSuccess():String = "This is a potential success message"
    val triedString = catchFailure.orElse(Try(potentialSuccess))
    println("This is printing the value of triedString :: "+triedString)
    println("orElse Use :: "+catchFailure.orElse(Try(potentialSuccess)))
  }

}
