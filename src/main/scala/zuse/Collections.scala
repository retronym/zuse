package zuse

import collection.Seq
import collection.immutable.{Map, List}

object Collections {
  // Scala collections are organized in a package structure:
  //
  // scala.collection
  //                 .TraversableOnce
  //                 .Traversable
  //                 .Seq
  //                 .IndexedSeq
  //                 .Set
  //                 .immutable
  //                            Seq
  //                            Set
  //                            List
  //                            Stream
  //                            Vector
  //                 .mutable
  //                            Seq
  //                            Set
  //                            Buffer
  //                            ListBuffer
  //                            ArrayBuffer

  // Commonly used collections have aliases, for example:
  //
  //  type Map[A, +B] = collection.immutable.Map[A, B]
  //  type Set[A] = collection.immutable.Set[A]
  //  val Map = collection.immutable.Map
  //  val Set = collection.immutable.Set

  // List is a singly linked, immutable list. You can prepend an element with ::, this leaves
  // the original list unchanged, and created a new list with an extra element. This is a very cheap
  // operation, as the old and new lists can share structure.
  val list1 = List(1, 2, 3)
  assert(list1 == 1 :: 2 :: 3 :: Nil)
  // Nil is the empty list.

  // :: is just a method call, with one trick, methods ending in ':' are right associative
  // It expands to this:
  Nil.::(3).::(2).::(1)

  // You can use a factory method to create a collection from elements.
  val seq: Seq[Int] = Seq(1, 2, 3)
  val is: IndexedSeq[String] = IndexedSeq.fill(20)("!")

  // Let's just focus on List for now. Most operations work across the other collections, too.

  val nums: List[Int] = (1 to 10).toList
  val mapped: List[Int] = nums.map(n => n * 2)
  val sum: Int = evens.sum

  // Filtering
  val evens: List[Int] = mapped.filter(n => n % 2 == 0)

  // Partitioning
  case class Person(name: String, age: Int)
  val people: List[Person] = List(Person("Bob", 25), Person("Betty", 15), Person("Boris", 42), Person("Bill", 25))
  val partitioned: (List[Person], List[Person]) = people.partition(_.age <= 18)
  val (minors, adults) = partitioned

  // Grouping
  val map: Map[Int, List[Person]] = people.groupBy(_.age)

  // Sorting
  val peopleByAge: List[Person] = people.sortBy(_.age)

  // drop/take
  val upToFirstTwoPeople = people.take(2)
  val upToFirstTenPeople = people.take(10)

  val allButFirstTwoPeople = people.drop(2)
  
}