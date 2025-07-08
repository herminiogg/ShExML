ThisBuild / organization := "com.herminiogarcia"
ThisBuild / organizationName := "herminiogarcia"
ThisBuild / organizationHomepage := Some(url("https://herminiogarcia.com"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/herminiogg/ShExML"),
    "scm:git@github.com:herminiogg/ShExML.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id    = "herminiogg",
    name  = "Herminio Garcia Gonzalez",
    email = "herminio@herminiogarcia.com",
    url   = url("https://herminiogarcia.com")
  )
)

ThisBuild / description := "A heterogeneous data mapping language based on Shape Expressions."
ThisBuild / licenses := List("MIT License" -> new URL("https://opensource.org/licenses/MIT"))
ThisBuild / homepage := Some(url("http://shexml.herminiogarcia.com"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }

ThisBuild / publishTo := {
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if (isSnapshot.value) Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}

ThisBuild / publishMavenStyle := true