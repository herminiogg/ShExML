organization := "es.weso"

name := "ShExML"

version := "1.0.0"

scalaVersion := "2.12.4"

libraryDependencies += "org.antlr" % "antlr4" % "4.7.1"

libraryDependencies += "io.gatling" % "jsonpath_2.12" % "0.6.10"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.4"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.4"

libraryDependencies += "com.nrinaudo" %% "kantan.xpath" % "0.3.2"

libraryDependencies += "org.apache.jena" % "apache-jena-libs" % "3.6.0" pomOnly()

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
