package spark.dataframes.fileformats

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{StructField, _}
import org.apache.spark.sql.{DataFrame, SparkSession}

object DfFileFormats {

  val spark = SparkSession.builder()
    .appName("DataFrame Methods")
    .master("local[*]")
    .getOrCreate()

  //val path ="datasets/cars.csv"
  //val path ="datasets/movies.txt"
  val path ="datasets/FL_insurance_sample.csv"

  val schema = StructType(Array(
    StructField("policyID",LongType,true),
    StructField("statecode",StringType,true),
    StructField("county",StringType,true),
    StructField("eq_site_limit",LongType,true),
    StructField("hu_site_limit",LongType,true),
    StructField("fl_site_limit",LongType,true),
    StructField("fr_site_limit",LongType,true),
    StructField("tiv_2011",LongType,true),
    StructField("tiv_2012",LongType,true),
    StructField("eq_site_deductible",FloatType,true),
    StructField("hu_site_deductible",LongType,true),
    StructField("fl_site_deductible",LongType,true),
    StructField("fr_site_deductible",FloatType,true),
    StructField("point_latitude",LongType,true),
    StructField("point_longitude",LongType,true),
    StructField("line",StringType,true),
    StructField("construction",IntegerType,true),
    StructField("point_granularity",LongType,true)
  ))

  def readAsDataFrame(path:String):DataFrame={
      spark.read .format("com.databricks.spark.csv").option("header", "true")
                                                             .option("inferSchema","true")
                                                            // .schema(schema)
                                                             .csv(path)
  }
  def performDataFrameOperations(): Unit ={
    val dataDf = readAsDataFrame(path)
    dataDf.printSchema()
    println("Count is  :: "+dataDf.count())
    dataDf.show(10,false)

    // Description of a specific column
    val frame = dataDf.describe("eq_site_limit")
    println("Showing Description")
    frame.show

    // Column names and Column Types
    println("Printing Column names and Column Types")
    dataDf.dtypes.foreach(println)

    // printing forst 10 elements
    println("Printing first 10 elements")
    dataDf.head(10).foreach(println)

    // GroupBy
    "groupingBy country"
    val groupDf = dataDf
                  .groupBy("county")
                  .count
    groupDf.show(10,false)
  }

  def readAsRdd(path:String): RDD[Char] ={
      spark.sparkContext.parallelize(path)
  }

  def performOperationOnRdd(path:String): Unit ={
   val dataRdd = readAsRdd(path)
    println("Printing RDD Data.......")
    dataRdd.take(10).foreach(println)
  }



  def main(args: Array[String]): Unit = {

    //performOperationOnRdd(path)
    performDataFrameOperations

  }

}
