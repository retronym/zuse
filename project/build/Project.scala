import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val specsDependency = "org.scala-tools.testing" %% "specs" % "1.6.5" % "test" withSources
}