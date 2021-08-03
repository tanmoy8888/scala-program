package read

import org.apache.log4j.LogManager
import org.apache.spark.sql.{Column, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

import java.beans.Transient

object ReadTextFile {

  @Transient val log = LogManager.getLogger(this.getClass)

  val spark = SparkSession
    .builder()
    .appName("Spark-Scala-project-1")
    .master("local[*]")
    .getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  val filePath = "E:/Hadoop/Data/movies/movies.txt"
  val schema = StructType(Array(
    StructField("movie_name",StringType,true),
    StructField("movie_type",StringType,true)
  ))
  val columnNames =Seq("movie_name","movie_type")

  def main(args: Array[String]): Unit = {
      log.info("Data Processing starts")
      val moviesRdd = sc.textFile(filePath)
      val splitrdd =  moviesRdd.map(e => e.split("#"))

      import sqlContext.implicits._
      val dataDf =  splitrdd.map(e => (e(1),e(2))).toDF(columnNames:_*)

      dataDf.printSchema

      //val finalDf = dataDf.select($"movie_name").withColumn("type", lastItem($"movie_type"))
      //finalDf.show(10,false)


      log.info("Data processing ends")
      spark.close()
  }

    def lastItem(items:Column) = items.toString().split("|").last.trim
  //def getLastIndex(colValue:String):String = colValue.split("|").last.trim
  //def getLastIndex(colValue:Column):Column = colValue.cast("string")
  //def getLastIndex(colValue:String):Column = colValue.split("|").last.trim.asInstanceOf[StringType]

  //def castMovieType(movietype:Column) : String = movietype.asInstanceOf[String]

}
