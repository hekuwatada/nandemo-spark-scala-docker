package org.nandemo.util

import org.scalatest.funspec._
import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class RandomDataGeneratorSpec extends AnyFunSpec {
  describe("randIntBetween()") {
    it("should return random numbers between min and max") {
      val actual = RandomDataGenerator.randIntBetween(5, 10)
      actual should (be >= 5 and be < 10)
    }
  }
}
