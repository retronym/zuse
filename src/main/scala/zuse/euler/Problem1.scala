package zuse.euler

/**
 * http://projecteuler.net/index.php?section=problems&id=1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem1 extends Application {
  def sumMultiples: Int = {
    (1 to 1000) filter (x => x % 3 == 0 || x % 5 == 0) sum
    
  }

  println(sumMultiples)
}