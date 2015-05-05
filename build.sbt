name := "kafka-scala"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalaz"       %% "scalaz-core"   % "7.1.1",
  "org.apache.kafka" %  "kafka-clients" % "0.8.2.1",
  "org.apache.kafka" %% "kafka"         % "0.8.2.1",
  "org.scalatest"    %% "scalatest"     % "2.2.4"     % "test"
)
    