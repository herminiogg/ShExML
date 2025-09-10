ThisBuild / organization := "com.herminiogarcia"

lazy val shexml = project
  .in(file("."))
  .settings(
    name := "ShExML",
    version := "0.6.0",
    scalaVersion := "3.3.6",
    crossScalaVersions := Seq("2.12.20", "2.13.16", "3.3.6"),
    libraryDependencies ++= Seq(
      "org.antlr" % "antlr4" % "4.9.2",
      "net.sf.saxon" % "Saxon-HE" % "12.4",
      "org.apache.jena" % "jena-base" % "3.17.0",
      "org.apache.jena" % "jena-core" % "3.17.0",
      "org.apache.jena" % "jena-arq" % "3.17.0",
      "org.apache.jena" % "jena-shacl" % "3.17.0",
      ("org.scalatest" %% "scalatest" % "3.2.9" % "test"),
      "info.picocli" % "picocli" % "4.7.7",
      "org.slf4j" % "slf4j-nop" % "1.7.27",
      ("com.github.tototoshi" %% "scala-csv" % "1.3.6").cross(CrossVersion.for3Use2_13),
      "org.xerial" % "sqlite-jdbc" % "3.32.3.2",
      "mysql" % "mysql-connector-java" % "8.0.21",
      "org.postgresql" % "postgresql" % "42.5.0",
      "org.mariadb.jdbc" % "mariadb-java-client" % "2.6.2",
      "com.microsoft.sqlserver" % "mssql-jdbc" % "8.4.1.jre8",
      ("com.github.vickumar1981" %% "stringdistance" % "1.2.6").cross(CrossVersion.for3Use2_13),
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
      "ch.qos.logback" % "logback-classic" % "1.3.5",
      "be.ugent.rml" % "rmlmapper" % "4.9.0" % "test",
      "es.weso" %% "shex" % "0.1.97" % "test",
      "es.weso" %% "srdf4j" % "0.1.104" % "test",
      "es.weso" %% "srdf" % "0.1.104" % "test",
      "com.jayway.jsonpath" % "json-path" % "2.8.0",
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) => "org.scala-lang" % "scala-reflect" % "2.13.9"
        case Some((2, n)) if n >= 12 => "org.scala-lang" % "scala-reflect" % scalaVersion.value
      },
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) => "org.scala-lang" % "scala-compiler" % "2.13.9"
        case Some((2, n)) if n >= 12 => "org.scala-lang" % "scala-compiler" % scalaVersion.value
      }) ++ (CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((m, n)) if m >= 3 || m >= 2 && n >= 13 => Seq("org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4")
      case _ => Nil
      }),
      assembly / assemblyMergeStrategy := {
        case PathList("META-INF", "services", xs @ _*) => MergeStrategy.concat
        case PathList("META-INF", xs @ _*) => MergeStrategy.discard
        case x => MergeStrategy.first
      }
  )