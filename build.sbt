name := "sentry-ootb-demo"

organization := "com.wingspan"

version := "1.0.0"

scalaVersion := "2.12.1"

lazy val scalactic = "org.scalactic" %% "scalactic" % "3.0.5"
lazy val scalacheck = "org.scalacheck" %% "scalacheck" % "1.13.5"
lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.5"
lazy val log4j = "log4j" % "log4j" % "1.2.17"
lazy val sentry = "io.sentry" % "sentry" % "1.6.3"
lazy val sentryLog4j = "io.sentry" % "sentry-log4j" % "1.7.1"
lazy val log4jOverSlf4j = "org.slf4j" % "slf4j-log4j12" % "1.7.25"


lazy val core = (project in file("core")).settings(
    scalaVersion := "2.12.1",
    libraryDependencies ++= Seq(
      scalactic,
      scalacheck % Test,
      scalatest % Test,
      log4j,
      log4jOverSlf4j,
      sentry,
      sentryLog4j
    )
  )
