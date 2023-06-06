val scala3Version = "3.3.0"

ThisBuild / organization := "com.bilal-fazlani"
ThisBuild / organizationName := "Bilal Fazlani"

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/bilal-fazlani/scala-aql"),
    "https://github.com/bilal-fazlani/scala-aql.git"
  )
)
ThisBuild / developers := List(
  Developer(
    "bilal-fazlani",
    "Bilal Fazlani",
    "bilal.m.fazlani@gmail.com",
    url("https://bilal-fazlani.com")
  )
)
ThisBuild / licenses := List(
  "MIT License" -> url(
    "https://github.com/bilal-fazlani/scala-aql/blob/main/license.md"
  )
)

ThisBuild / homepage := Some(url("https://scala-aql.bilal-fazlani.com/"))

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-aql",
    scalaVersion := scala3Version
  )
  
