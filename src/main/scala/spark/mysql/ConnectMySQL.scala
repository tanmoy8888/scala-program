package spark.mysql

import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.{SaveMode, SparkSession}

import java.util.Properties

object ConnectMySQL {
  val spark = SparkSession.builder()
    .appName("DataFrame Methods")
    .master("local[*]")
    .getOrCreate()

  val path ="datasets/TechCrunchcontinentalUSA.csv"

  /**
   * MySQL Details
   * @param path
   * @return
   */
    val url = "jdbc:mysql://localhost:3306"
    val table = "classicmodels.customers"
    val properties = new Properties();
    val writeTable = "spark_db.company_df"
    properties.put("user","root")
    properties.put("password","my-pass")

   def readFromMySQL(url:String,table:String,properties: Properties) ={
     Class.forName("com.mysql.jdbc.Driver")
     spark.read.jdbc(url,table,properties)
   }

  def writeDataInMySQL(path:String)={
    val data = spark.read
      .option("header","true")
      .option("inferSchema","true")
      .csv(path)
    data.write.mode(SaveMode.Append).jdbc(url,writeTable,properties)
    println("Writing data in MySQL Table........")
  }

  // UDF
  def convertToLowerCase(str:String) = str.toLowerCase
  def udfLowerCase  = udf[String,String](convertToLowerCase)


  import spark.implicits._

  def perfromMySQLReadOperation(): Unit ={
    val data = readFromMySQL(url,table,properties)
    data.printSchema()
    // data.show(5,false)
    val cols = List("customerNumber","customerName","contactLastName","contactFirstName","phone","state","country")
    val dataDf = data.select($"state",udfLowerCase($"country"))
     //data.select($"state",udfLowerCase($"country"))
    //data.select("customerNumber","customerName","contactLastName","contactFirstName","phone","state","country")
      //.select(cols.map(col(_)):_*)
      //.select(cols.map(c => col(c)): _*)
     // .groupBy($"state",udfLowerCase($"country"))
    //dataDf.count.show
    dataDf.show(20,false)
  }

  def perfromMySQLWriteOperation(): Unit ={
    writeDataInMySQL(path)
  }

  def main(args: Array[String]): Unit = {
    perfromMySQLReadOperation
    //perfromMySQLWriteOperation


    spark.stop()
  }

}
