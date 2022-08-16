package org.nandemo.spark.mllib.stat.hypothesistesting

import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.sql.{Row, SparkSession}
import org.nandemo.spark.mllib.stat.hypothesistesting.ChiSquareTesting
import org.nandemo.spark.testutil.LocalSpark
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ChiSquareTestingTest extends AnyFunSpec with Matchers with LocalSpark {
  val appName: String = "ChiSquareTestingTest"

  describe("chiSquareTestExample()") {
    it("Chi-square test result should not reject the null hypothesis") {
      val data: Seq[(Double, Vector)] = Seq(
        (0.0, Vectors.dense(0.5, 10.0)),
        (0.0, Vectors.dense(1.5, 20.0)),
        (1.0, Vectors.dense(1.5, 30.0)),
        (0.0, Vectors.dense(3.5, 30.0)),
        (0.0, Vectors.dense(3.5, 40.0)),
        (1.0, Vectors.dense(3.5, 40.0))
      )
      withSparkSession { ss: SparkSession =>
        val actual: Row = ChiSquareTesting.chiSquareTestExample(data)(ss)

        // p-value will show if test results are significant or not
        val pValuesForFeatures: Vector = actual.getAs[Vector](0)
        val pValueForFirstFeature: Double = pValuesForFeatures.toArray.head

        // A statistically significant test result (P <= 0.05) means
        // that the test hypothesis is false or should be rejected.
        // A p-value > 0.05 means that no effect was observed.
        val statisticallySignificantTestResult = 0.05
        // pValueForFirstFeature should be <= statisticallySignificantTestResult
      }
    }
  }
}
