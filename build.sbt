import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

val scala3Version = "3.3.0"
val scala2Version = "2.13.10"

ThisBuild / organization := "com.bilal-fazlani"
ThisBuild / organizationName := "Bilal Fazlani"

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

lazy val root = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    name := "scala-aql",
    scalaVersion := scala2Version,
    crossScalaVersions := Seq(scala2Version, scala3Version)
  )
  .jsSettings(
      scalaJSUseMainModuleInitializer := true
    )
