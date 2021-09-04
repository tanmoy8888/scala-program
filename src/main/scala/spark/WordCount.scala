package spark

import org.apache.spark.sql.SparkSession

object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Spark-Scala-project-1")
      .master("local[*]")
      .getOrCreate()

    val file ="C:\\Users\\Tanmoy\\Desktop\\Questions.txt"
    val conext = spark.sparkContext
    val data = conext.textFile(file)
    //data.foreach(println)


      data.flatMap(_.split(" "))
          .map((_,1))
          .reduceByKey(_+_)
          .foreach(println)
   /*
    data.flatMap(line => line.split(" "))
      .map(word => (word,1))
      .reduceByKey(_+_)
      .foreach(println)

     */

    spark.stop()
  }

}
