package zuse

object Patterns {
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 32)

  // A pattern match introduces new variable bindings `name` and `value`.
  val Person(name, age) = bob

  val classification = bob match {
    case Person("Bob", age) if age < 18 => "Young Bob is %d years old".format(age)
    case Person("Bob", _) => "Old Bob"
    case _ => "stranger"
  }

  // you can pattern match on Lists
  def quickSort(as: List[Int]): List[Int] = as match {
    case Nil => Nil
    case head :: tail => // The the list must be of the form ::(head, tail), where tail might be empty.
      val (lows, highs) = tail partition (_ < head)
      quickSort(lows) ::: head :: quickSort(highs)
  }

  // Regular Expression matching
  val PhoneNumber = """(\d{3})-(\d{8})""".r
  val PhoneNumber(prefix, suffix) = "123-1235678"

  // Patterns can be nested. You can match against equality of a value by enclosing it in backticks.
  val x: Option[List[Int]] = Some(List(1, 2))
  val one = 1
  // Introduces a new binding 'two' with the value 2
  val Some(List(`one`, two)) = x

  // Pattern Matching works on any object (including an instance of a class) with a suitable
  // unapply or unapplySeq method.
  object && {
    def unapply[T](x: T) = Some((x, x))
  }
  object AgeGroup {
    def unapply(p: Person) = p.age match {
      case x if x < 18 => Some("Young")
      case x if x < 120 => Some("Old")
      case _ => None
    }
  }
  val AgeGroup(bobsAgeGroup) && Person(_, bobsAge) = bob


}