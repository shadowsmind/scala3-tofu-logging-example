lazy val commonSettings = Seq(
  organization := "tf.tofu",
  scalaVersion := Dependencies.Versions.scala,
  version      := "0.1",
  scalacOptions ++= Seq("-Xmax-inlines", "200"),
  developers   := List(
    Developer(
      "shadowsmind",
      "Alexandr Oshlakov",
      "aoshlakov@onlinetours.ru",
      url("https://github.com/shadowsmind")
    )
  )
)

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "scala3-logging-example",
    libraryDependencies ++= Dependencies.Modules.App
  )
