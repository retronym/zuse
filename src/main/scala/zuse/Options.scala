package zuse

object Options {
  // In Java, it's common practice to represent a missing value with 'null'. This conforms to any reference
  // type at all. If you read the type signature of System.getProperty, you would not know that it sometimes
  // returns null -- you must read the documentation, and remember to add null checks each time you call it.

  // Scala discourages the use of null, and offers an alternative: Option[A]

  val countries: Map[String, String] = Map("CH" -> "Switzerland", "DE" -> "Germany", "IT" -> "Italy")

  val chName: Option[String] = countries.get("CH")
  assert(chName.isDefined)
  assert(!chName.isEmpty)

  // Pattern matching forces you do deal with the possibility of a missing value
  val name: String = chName match {
    case Some(name) => name
    case None => "default"
  }

  // There are other ways to handle this:
  val name1: String = chName.getOrElse("default")

  // The argument to getOrElse is call-by-name, that is it is defined `getOrElse(else: => A)`.
  // It is not evaluated if the option is defined, so we can throw an exception in th argument:
  val name2: String = chName.getOrElse(error("no name!"))

  // If both "CH" and "FR" are in the map, return Some(message), otherwise None.
  val messageOption: Option[String] = for {
    chName <- countries.get("CH")
    frName <- countries.get("FR")
  } yield "I drove from %s to %s".format(chName, frName)

}