ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

val sparkVersion = "3.2.2"
val typesafeVersion = "2.0.0"
val prodLibs = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

val scalaTestVersion = "3.2.13"
val testLibs = Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
  "org.scalactic" %% "scalactic" % scalaTestVersion % Test
)

lazy val root = (project in file("."))
  .settings(
    name := "nandemo-spark-scala-docker",
    libraryDependencies ++= prodLibs ++ testLibs
  )
