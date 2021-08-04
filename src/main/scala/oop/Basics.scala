package oop

class Employee(name:String,val title:String){
  def hello(title:String) = println(s"Hi this is ${this.name} "+title)
  def this(name:String) = this(name,"Mukherjee")
}

class Animal with FoodHabits with Type{
  override  def foodhabits = ""
}
object Basics {
  def main(args: Array[String]): Unit = {
    val emp = new Employee("Tanmoy","Mukherjee")
    println(emp.title)
    emp.hello("Mukherjee")



  }


}
