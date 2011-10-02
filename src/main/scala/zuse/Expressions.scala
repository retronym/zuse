package zuse

object Expressions {
  var a: Int = 1
  val b: Int = a + a
  val c = true

  val d = if (c)
    a
  else
    b

  val e: Int = try {
    d
  } catch {
    case _ => -1
  }

  val f: Int = e match {
    case 1 => 100
    case _ => 1
  }

  def okay(i: Int) = if (i > 9) true else false


  val xs: Seq[(Int, Int)] = for{
    x <- Seq(1, 2, 3)
    y <- Seq(1, 2, 3)
  } yield (x, y)

  // The result of a block, that is a series of statements between {}, is the value
  // of the final expression.
  val g: Int = {
    1
    2
    3
  }

  // For statements or method calls that can't return a value, the special value
  // () of type Unit is used.
  val u1: Unit = while (false) println("")
  val u2: Unit = println("foo")
  val u3: Unit = ()

  // For methods that don't actually return at all, the type Nothing can be used.
  lazy val n1: Nothing = error("")

  def n2: Nothing = n2
}