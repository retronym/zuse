package zuse

object Functions {
  // Scala defines traits Function0 to Function22
  //   Function0[A] is like java.util.concurrent.Callable[A]
  //   Function0[Unit] is like java.lang.Runnable

  class PlusOne extends Function1[Int, Int] {
    def apply(v1: Int) = v1 + 1
  }

  assert((new PlusOne).apply(0) == 1)

  // That was way too verbose! Luckily, their is a built in syntax for defining anonymous functions
  // and for calling functions.
  val plusOne = (i: Int) => i + 1
  assert(plusOne(0) == 1)

  // Because functions are just instances of the FunctionN trait, they can be
  // passed to, and returned from, methods/functions. This means the are a 'first-class'
  // concept in the language.
  def compose[A, B, C](f: A => B)(g: B => C): A => C = (a: A) => g(f(a))

  // First class functions are used heavily in the Scala collections framework.
  // The function (x * 2) is applied in turn to each element in the collection,
  // and a new collection is returned.
  val seq = Seq(1, 2, 3).map(x => x * 2)

  // Type inference can make this more succinct.
  Seq(1, 2, 3).map(x => x * 2)
  // Placeholder syntax for anonymous functions.
  Seq(1, 2, 3).map(_ * 2)

  case class Person(age: Int, name: String)
  val people: Seq[Person] = Seq(Person(12, "betty"), Person(15, "billy"))
  people.sortBy((p) => p.age)
  people.map(_.name)

  // The final argument to a method call can be enclosed in braces, rather than parentheses.
  // This is useful for multi-line functions.
  Seq(1, 2, 3).map {
    x =>
      println("s1")
      println("s2")
      // this is the return value of the function.
      x * 2
  }
}