organization := "es.weso"

name := "ShExML"

version := "0.2.2"

scalaVersion := "2.12.4"

resolvers += "jitpack" at "https://jitpack.io"

resolvers += "binTray" at "https://dl.bintray.com/labra/maven/"

libraryDependencies += "org.antlr" % "antlr4" % "4.8"

libraryDependencies += "io.gatling" % "jsonpath_2.12" % "0.6.10"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.4"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.4"

libraryDependencies += "com.nrinaudo" %% "kantan.xpath" % "0.3.2"

libraryDependencies += "org.apache.jena" % "apache-jena-libs" % "3.16.0" pomOnly()

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"

libraryDependencies += "com.github.RMLio" % "rmlmapper-java" % "v4.8.2" % "test"

libraryDependencies += "info.picocli" % "picocli" % "4.0.4"

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.27"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.6"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.32.3.2"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.21"

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.16"

libraryDependencies += "org.mariadb.jdbc" % "mariadb-java-client" % "2.6.2"

libraryDependencies += "com.microsoft.sqlserver" % "mssql-jdbc" % "8.4.1.jre8"

libraryDependencies += "es.weso" %% "shex" % "0.1.71" % "test"

libraryDependencies += "es.weso" %% "srdf4j" % "0.1.76" % "test"

libraryDependencies += "es.weso" %% "srdf" % "0.1.76" % "test"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
