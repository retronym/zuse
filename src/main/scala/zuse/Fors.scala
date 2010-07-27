package zuse

import collection.immutable.IndexedSeq

object Fors {
  for (i <- Seq(1, 2, 3)) println(i)
  
  val seq: IndexedSeq[Int] = for{
    i <- 1 to 4
    j <- 1 to i
    ij = i * j
    if ij > 3
  } yield ij

}