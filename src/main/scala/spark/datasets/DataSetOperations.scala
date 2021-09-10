package spark.datasets

import org.apache.spark.sql.SparkSession

object DataSetOperations {

  val spark = SparkSession.builder()
    .appName("DataFrame Methods")
    .master("local[*]")
    .getOrCreate()

  val path ="datasets/TechCrunchcontinentalUSA.csv"

  def readAsDataSet(path:String)={
    import spark.implicits._
    spark.read
         .option("header","true")
         .option("inferSchema","true")
         .csv(path)
      .as[Company]
  }

  def main(args: Array[String]): Unit = {
    val ds = readAsDataSet(path)
    ds.printSchema()
    println("Printing values from datasets")
    ds.show(10,false)
    val filteredDs = ds.filter(_.state =="CA")
    println("Total number of state(CA) count is :: "+filteredDs.count())
  }

}
