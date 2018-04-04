name := """documento-web"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.12.2"

//resolvers += Resolver.url("sbt-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)


//RAQUINO Soporte para MYSQL
libraryDependencies += jdbc
libraryDependencies += guice

//RAQUINO Soporte para MYSQL: AGREGANDO LIBRERIA JDBC
//https://stackoverflow.com/questions/30905318/play-framework-unresolved-dependency-with-mysql-connector
//https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-versions.html
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.42"

// https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.21.0.1"


// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.194"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox
libraryDependencies += "org.apache.pdfbox" % "pdfbox" % "2.0.9"

// https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox-tools
libraryDependencies += "org.apache.pdfbox" % "pdfbox-tools" % "2.0.9"

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
