package zuse

object Tuples {
  // Scala defines Tuple classes from arity 1 to 22.
  new Tuple3[Int, String, Int](-1, "0", 1)

  // Inferring the type parameters
  new Tuple3(-1, "0", 1)

  // Calling the Factory method Tuple3.apply
  Tuple3.apply(-1, "0", 1)

  // The method name 'apply' is special, it can be omitted
  Tuple3(-1, "0", 1)

  // Tuples are so handy, that there is even a special syntax:
  val t: (Int, String, Int) = (-1, "0", 1)

  // Elements from the Tuple can be accessed with methods _1, _2, etc.
  assert(t._1 + t._3 == 0)

  // Tuples can also deconstructed with pattern matching
  val (a, _, c) = t
  assert(a + c == 0)

  // Tuples, like all case classes, can be copied with some changes
  assert(t.copy(_2 = "boo") == (-1, "boo", 1))
}