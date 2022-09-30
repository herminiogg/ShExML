organization := "com.herminiogarcia"

name := "ShExML"

version := "0.3.1"

scalaVersion := "2.13.9"

//resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies += "org.antlr" % "antlr4" % "4.9.2"

libraryDependencies += "io.gatling" % "gatling-jsonpath" % "3.8.4"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.4"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.4"

libraryDependencies += "com.nrinaudo" %% "kantan.xpath" % "0.5.3"

libraryDependencies += "org.apache.jena" % "apache-jena-libs" % "3.17.0" pomOnly()

libraryDependencies += "org.apache.jena" % "jena-arq" % "3.17.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

libraryDependencies += "be.ugent.rml" % "rmlmapper" % "4.9.0" % "test"

libraryDependencies += "info.picocli" % "picocli" % "4.0.4"

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.27"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.6"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.32.3.2"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.21"

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.16"

libraryDependencies += "org.mariadb.jdbc" % "mariadb-java-client" % "2.6.2"

libraryDependencies += "com.microsoft.sqlserver" % "mssql-jdbc" % "8.4.1.jre8"

libraryDependencies += "com.github.vickumar1981" %% "stringdistance" % "1.2.6"

libraryDependencies += "es.weso" %% "shex" % "0.1.97" % "test"

libraryDependencies += "es.weso" %% "srdf4j" % "0.1.104" % "test"

libraryDependencies += "es.weso" %% "srdf" % "0.1.104" % "test"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.13.9"

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.13.9"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
