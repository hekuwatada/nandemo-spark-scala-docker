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

## sbt
```
sbt compile

# to reflect changes in build.sbt
sbt reload

# to run all tests
sbt test

sbt clean
```