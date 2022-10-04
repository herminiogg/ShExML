ThisBuild / organization := "com.herminiogarcia"

lazy val shexml = project
  .in(file("."))
  .settings(
    name := "ShExML",
    version := "0.3.1",
    scalaVersion := "2.13.9",
    crossScalaVersions := Seq("2.12.17", "2.13.9"),
    libraryDependencies ++= Seq(
      "org.antlr" % "antlr4" % "4.9.2",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.9.4",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.4",
      "com.nrinaudo" %% "kantan.xpath" % "0.5.3",
      "org.apache.jena" % "jena-base" % "3.17.0",
      "org.apache.jena" % "jena-core" % "3.17.0",
      "org.apache.jena" % "jena-arq" % "3.17.0",
      "org.apache.jena" % "jena-shacl" % "3.17.0",
      "org.scalatest" %% "scalatest" % "3.0.8" % "test",
      "info.picocli" % "picocli" % "4.0.4",
      "org.slf4j" % "slf4j-nop" % "1.7.27",
      "com.github.tototoshi" %% "scala-csv" % "1.3.6",
      "org.xerial" % "sqlite-jdbc" % "3.32.3.2",
      "mysql" % "mysql-connector-java" % "8.0.21",
      "org.postgresql" % "postgresql" % "42.5.0",
      "org.mariadb.jdbc" % "mariadb-java-client" % "2.6.2",
      "com.microsoft.sqlserver" % "mssql-jdbc" % "8.4.1.jre8",
      "com.github.vickumar1981" %% "stringdistance" % "1.2.6",
      "be.ugent.rml" % "rmlmapper" % "4.9.0" % "test",
      "es.weso" %% "shex" % "0.1.97" % "test",
      "es.weso" %% "srdf4j" % "0.1.104" % "test",
      "es.weso" %% "srdf" % "0.1.104" % "test",
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scala-lang" % "scala-compiler" % scalaVersion.value,
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, n)) if n == 13 => "io.gatling" % "gatling-jsonpath" % "3.8.2"
        case Some((2, n)) if n == 12 => "io.gatling" % "gatling-jsonpath" % "3.4.2"
      }),
      assembly / assemblyMergeStrategy := {
        case PathList("META-INF", xs @ _*) => MergeStrategy.discard
        case x => MergeStrategy.first
      }
  )