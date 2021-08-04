package com.tanmoy.my.project.start

import org.apache.spark.sql.SparkSession

object RunApplication {
  def main(args: Array[String]): Unit = {
    println("Spark Execution Started")

    val spark = SparkSession
      .builder()
      .appName("Spark-Scala-project-1")
      .master("local[*]")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val sc =spark.sparkContext
    val data =List("ABC","DEF","GHI","JKL","MNO")
    val datardd=sc.parallelize(data)
    val lowrdd = datardd.map(e => e.toLowerCase)
      .collect()
      .foreach(println)

    spark.stop()

    println("Spark Execution Stopped")

  }

}
