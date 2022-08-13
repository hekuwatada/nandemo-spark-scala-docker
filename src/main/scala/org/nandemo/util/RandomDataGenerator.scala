package org.nandemo.util

object RandomDataGenerator {
  def randIntBetween(min: Int, max: Int) = {
    scala.util.Random.nextInt(max - min) + min
  }
}