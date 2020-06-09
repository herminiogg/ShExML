organization := "es.weso"

name := "ShExML"

version := "0.2.1"

scalaVersion := "2.12.4"

resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies += "org.antlr" % "antlr4" % "4.7.1"

libraryDependencies += "io.gatling" % "jsonpath_2.12" % "0.6.10"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.4"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.4"

libraryDependencies += "com.nrinaudo" %% "kantan.xpath" % "0.3.2"

libraryDependencies += "org.apache.jena" % "apache-jena-libs" % "3.6.0" pomOnly()

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"

libraryDependencies += "com.github.RMLio" % "rmlmapper-java" % "v4.3.3" % "test"

libraryDependencies += "info.picocli" % "picocli" % "4.0.4"

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.27"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.6"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
