import sbt._
import org.apache.ivy.core.module.descriptor.ExcludeRule

object Dependencies {

  object Versions {
    val scala = "3.1.3"

    val cats              = "2.8.0"
    val catsEffect        = "3.3.14"
    val fs2               = "3.2.10"
    val tofu              = "0.10.8"
    val circe             = "0.14.0"
    val janino            = "3.1.7"
    val log4cats          = "2.4.0"
    val scalatest         = "3.2.12"
    val catsEffectTesting = "1.4.0"
  }

  object Runtime {
    val cats       = "org.typelevel" %% "cats-core"   % Versions.cats
    val catsEffect = "org.typelevel" %% "cats-effect" % Versions.catsEffect
    val fs2        = "co.fs2"        %% "fs2-core"    % Versions.fs2

    val all: Seq[ModuleID] = Seq(cats, catsEffect, fs2)
  }

  object Json {
    val circeCore    = "io.circe" %% "circe-core"    % Versions.circe
    val circeParser  = "io.circe" %% "circe-parser"  % Versions.circe
    val circeGeneric = "io.circe" %% "circe-generic" % Versions.circe

    val all: Seq[ModuleID] = Seq(circeCore, circeParser, circeGeneric)
  }

  object Logging {
    val janino        = "org.codehaus.janino" % "janino"         % Versions.janino
    val log4catsCore  = "org.typelevel"      %% "log4cats-core"  % Versions.log4cats
    val log4catsSlf4j = "org.typelevel"      %% "log4cats-slf4j" % Versions.log4cats
    val tofuLogging   = "tf.tofu"            %% "tofu-logging"   % Versions.tofu cross CrossVersion.for3Use2_13 excludeAll (
      ExclusionRule(organization = "org.scala-lang.modules"),
      ExclusionRule(organization = "org.typelevel"),
      ExclusionRule(organization = "io.circe")
    )

    val all: Seq[ModuleID] = Seq(janino, log4catsCore, log4catsSlf4j, tofuLogging)
  }

  object Testing {
    val scalatest   = "org.scalatest" %% "scalatest"                     % Versions.scalatest         % Test
    val scalactic   = "org.scalactic" %% "scalactic"                     % Versions.scalatest         % Test
    val catsEffects = "org.typelevel" %% "cats-effect-testing-scalatest" % Versions.catsEffectTesting % Test

    val core: Seq[ModuleID] = Seq(scalatest, scalactic)
    val all: Seq[ModuleID]  = core :+ catsEffects
  }

  object Modules {
    val App: Seq[ModuleID] = Runtime.all ++ Testing.core ++ Logging.all
  }

}
