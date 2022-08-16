package org.nandemo.spark.mllib.stat.hypothesistesting

import org.apache.spark.ml.linalg.Vector
import org.apache.spark.ml.stat.ChiSquareTest
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object ChiSquareTesting {
  // https://spark.apache.org/docs/latest/ml-statistics.html#chisquaretest
  // @param data - sequence of label as Double and features as Vector,
  //               ie (label, features) where features will be interpreted as (column, value)
  def chiSquareTestExample(data: Seq[(Double, Vector)])(implicit ss: SparkSession): Row = {
    import ss.implicits._

    val df = data.toDF("label", "features")
    println(df.show())
    // The structure of df will look like below:
    //    +-----+----------+
    //    | label | features |
    //    +-----+----------+
    //    |0.0 |[0.5, 10.0] |
    //    |0.0 |[1.5, 20.0] |
    //    |1.0 |[1.5, 30.0] |
    //    |0.0 |[3.5, 30.0] |
    //    |0.0 |[3.5, 40.0] |
    //    |1.0 |[3.5, 40.0] |
    //    +-----+----------+

    val testResult: DataFrame = ChiSquareTest.test(df, "features", "label")
    println(testResult.show())
    // The structure of testResult wil look like below:
//    +--------------------+----------------+----------+
//    | pValues | degreesOfFreedom | statistics |
//    +--------------------+----------------+----------+
//    |[0.68728927879097...|[2, 3] |[0.75, 1.5] |
//    +--------------------+----------------+----------+

    val chi: Row = testResult.head
    println(s"pValues = ${chi.getAs[Vector](0)}")
    println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
    println(s"statistics ${chi.getAs[Vector](2)}")
    chi
  }
}
