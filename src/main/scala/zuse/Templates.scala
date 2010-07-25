package zuse

object Templates {
  // All code must be contained in Classes, Objects, and Traits.
  // These are all defined with a Template.

  // Right now, we're in the object Templates.

  object Adder {
    // `def` introduces a method.
    def plus(a: Int, b: Int): Int = a + b
  }

  object UseAdder {
    val r1: Int = Adder.plus(1, 1)

    // We can omit the type of r2, and let the compiler infer it.
    val r2 = Adder.plus(1, 1)

    // The '.' can be omitted in some cases, this is useful for
    // creating embedded DSLs.
    Adder plus (1, 2)

    // Imports bring members
    import Adder.plus
    plus(1, 2)
  }

  // A class is defined with its name and the parameters for its primary constructor.
  // Any code directly in the body of the class is executed during construction.
  class Greeter(cowboy: Boolean) {
    println("In the primary constructor of Greeter")

    // Auxiliary constructors are defined with `def this(...)`. They must delegate to the primary constructor immediately.
    def this() {
      this (false)
      println("In the auxillary constructor of Greeter")
    }

    def greet: String = if (cowboy) "Hello, World!" else "Howdy, Partner!"
  }

  // An instance of a class is created with the `new` keyword.
  new Greeter(true).greet
  new Greeter().greet

  // Advanced.
  val Seq(greeting1, greeting2) = Seq(new Greeter(true), new Greeter()).map(_.greet)

  // Traits can be used to:
  //   - declare an abstract interface
  //   - mix behaviour into a class
  //   - wrap
  trait Random {
    def nextInt(): Int
  }

  trait NotVeryRandom extends Random {
    def nextInt() = 42
  }


  // So, what can go in a template?
  // Firstly, value members: vals, vars, methods, and nested objects.
  new {
    val v1: Int = 0
    println(v1)

    // var x introduces
    //   - a field (not directly accessible),
    //   - a getter method `x`
    //   - a setter method `x_=`
    var v2: Int = 0
    // calling the setter
    v2_=(v2 + 1)
    // Syntactic sugar for calling the setter
    v2 = v2 + 1
    // More syntactic sugar, expands to v2 = v2 + 1
    v2 += 1

    def m1 = 0
    def m2(p: Any) = 0
    def m2(p1: Any, p2: Int) = 0

    // The parameters can actually be grouped into 0-N parameter lists.
    def m3(p1: Any)(p2: Int) = 0
    m3("")(0)

    // parameters can have default values 
    def m4(p1: Int, p2: String = "<default>") = 0
    // and can be called by name.
    m4(0); m4(p1 = 0, p2 = "")

    // methods can have type parameters:
    def second[A](as: Traversable[A]): A = as.tail.head

    object A
  }

  // Second, templates can contain type members:
  new {
    trait T
    class C
    // type aliases
    type Text = String

    // type aliases can have type parameters
    type IntMap[A] = Map[Int, A]
  }

  // In traits, and in abstract classes, members can have a declaration without a definition.
  // These must be eventually defined in an extending class.
}