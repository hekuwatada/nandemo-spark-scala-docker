# Templates and examples of Spark 3.2.x

## Setup for IntelliJ user
1. Install Java SDK 17
```
sdk install java 17.0.4.fx-zulu
```
2. Install Scala SDK 2.13.8
```
sdk install scala 2.13.8
```
3. Install sbt (on Mac)
```
brew install sbt
```
4. Open this project in IntelliJ as sbt project
5. `Reload All sbt Project` on the right panel
6. Set Scala SDK in IntelliJ (if either build.sbt or Scala files have errors)
- `Project name > Add Framework Support > Create`
- Try `File > Invalidate Caches / Restart` if the SDK is not recognised
7. Set Java SDK in IntelliJ (if either build.sbt or Scala files have errors)
- `File > Project structure > Project settings > Add SDK`

### Troubleshooting for IntelliJ user

#### Unable to compile or run tests with Java 11
```
java.lang.IllegalAccessError: class org.apache.spark.storage.StorageUtils$ (in unnamed module) cannot access class sun.nio.ch.DirectBuffer (in module java.base) because module java.base does not export sun.nio.ch to unnamed module
```
- You may see above error with the combination of Scala 2.13.8, Spark 3.2.2 and Java 11
- Workaround 1: Edit Run configurations > JRE > select Java 8
- Workaround 2: Run tests with sbt

## sbt
```
sbt compile

# to reflect changes in build.sbt
sbt reload

# to run all tests
sbt test

sbt clean
```
