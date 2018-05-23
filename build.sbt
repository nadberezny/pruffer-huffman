import Dependencies._

lazy val root = (project in file(".")).
  settings(
      inThisBuild(List(
          organization := "nadberezny",
          scalaVersion := "2.12.6",
          version      := "0.1.0-SNAPSHOT"
  )),
  name := "pruffer-huffman",
  mainClass in Compile := Some("nadberezny.MainApp"),
  mainClass in assembly := Some("nadberezny.MainApp"),
  libraryDependencies += scalaTest % Test
  )
