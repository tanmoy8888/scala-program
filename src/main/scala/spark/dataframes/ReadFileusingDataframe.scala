package spark.dataframes

import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object ReadFileusingDataframe {

  val spark = SparkSession
    .builder()
    .appName("Spark-Scala-project-1")
    .master("local[*]")
    .getOrCreate()

  val path ="datasets/movies.txt"
  val sc = spark.sparkContext

  def main(args: Array[String]): Unit = {
    val data = sc.textFile(path)
    val datardd = data.map(_.split("#"))
                      .map(a => Row(a(0),a(1),a(2)))

    val schema = StructType(Array(
                      StructField("id",StringType,true),
                      StructField("movie_name",StringType,true),
                      StructField("type",StringType,true)))
    val Df = spark.createDataFrame(datardd,schema)

    println(Df.show(20,false))
  }

}
